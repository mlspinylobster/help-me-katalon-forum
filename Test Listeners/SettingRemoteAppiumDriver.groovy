import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.appium.driver.AppiumDriverManager as AppiumDriverManager
import com.kms.katalon.core.mobile.driver.MobileDriverType as MobileDriverType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.internal.PathUtil as PathUtil

class SettingRemoteAppiumDriver {
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		println "checking whether any stored drivers exists..."
		def storedDrivers = RunConfiguration.getStoredDrivers()
		if (storedDrivers.size() > 0) {
			return;
		}
		println "no drivers found"
		
		println "checking whether WebUI driver is specified..."
		def exProps = RunConfiguration.getExecutionProperties()
		if (exProps.drivers.system.WebUI == null) {
			return;
		}
		
		println "start Appium Driver..."
		exProps = exProps.drivers.system.WebUI
		
		DesiredCapabilities capabilities = new DesiredCapabilities()
		println "DesiredCapabilities"
		def capMap = RunConfiguration.getDriverPreferencesProperties()["WebUI"]
		capMap.each { key, val ->
			println key + ": " + val
			capabilities.setCapability(key, val)
		}
		def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AndroidApp, RunConfiguration.getProjectDir())
		println "app path is: " + appPath
		capabilities.setCapability("app", appPath)
		
		def appiumUrl = exProps.remoteWebDriverUrl
		AppiumDriverManager.createMobileDriver(MobileDriverType.ANDROID_DRIVER, capabilities, new URL(appiumUrl))
	}
}