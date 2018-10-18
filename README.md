# Help!

I can't execute tests via Remote!

## Test via Remote execution

[log directory](/Reports/Sample%20Test/20181015_174454)

### Preparation

```bash
$ adb devices
List of devices attached
adb server version (40) doesn't match this client (39); killing...
* daemon started successfully *
emulator-5554	device

$ appium
[Appium] Welcome to Appium v1.8.1 (REV a33909737958ca807e4b1c2791a1f137fc489c3d)
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
```

### Execution command

```bash
$ wd=$(pwd)
$ /Applications/Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -projectPath="${wd}/KatalonAndroidSample.prj" -retry=0 -testSuitePath="Test Suites/Sample Test" -remoteWebDriverType="Appium" -executionProfile="default" -remoteWebDriverUrl="http://localhost:4723/wd/hub" -browserType="Remote"
```

## Test via Android execution

[log directory](/Reports/Sample%20Test/20181015_171402)

### Execution command

```bash
$ wd=$(pwd)
$ device_id='emulator-5554' 
$ /Applications/Katalon\ Studio.app/Contents/MacOS/katalon --args -noSplash  -runMode=console -projectPath="${wd}/KatalonAndroidSample.prj" -retry=0 -testSuitePath="Test Suites/Sample Test" -executionProfile="default" -deviceId="$device_id" -browserType="Android"
```

