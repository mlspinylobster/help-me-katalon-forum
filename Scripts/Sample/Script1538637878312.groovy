import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.internal.PathUtil as PathUtil

def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AndroidApp, RunConfiguration.getProjectDir())
Mobile.startApplication(appPath, false)

def message = findTestObject('Application/App/Activity/ActivityMain/message')
def navButton = findTestObject('Application/App/Activity/ActivityMain/navButton')
def button = findTestObject('Application/App/Activity/ActivityMain/button')

def messageText = Mobile.getText(message, 10)
Mobile.verifyEqual(messageText, 'Home')

Mobile.tap(navButton, 10)

messageText = Mobile.getText(message, 10)
Mobile.verifyEqual(messageText, 'Dashboard')

def btnText = Mobile.getText(button, 10)
Mobile.verifyEqual(btnText, 'Click!')

Mobile.tap(button, 10)

btnText = Mobile.getText(button, 10)
Mobile.verifyEqual(btnText, 'Clicked')

Mobile.closeApplication()

