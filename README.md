# ~~Help!~~

~~I can't execute tests via Remote!~~
**It resolved. Thanks a lot!**

## Test via Remote execution

[log directory](/Reports/Sample%20Test/20181015_174454)

### Preparation

**Note: OS is macOS**

Check whether your Android device is recognized by your machine.

```bash
$ adb devices
List of devices attached
adb server version (40) doesn't match this client (39); killing...
* daemon started successfully *
81d7d62f	device

```

Start Appium v1.8.1 locally.

```bash
$ npx appium@1.8.1
[Appium] Welcome to Appium v1.8.1 (REV a33909737958ca807e4b1c2791a1f137fc489c3d)
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
```

### Execution command

```bash
$ wd=$(pwd)
$ cd /Applications/
$ ./Katalon\ Studio.app/Contents/MacOS/katalon --args -runMode=console -reportFolder="${wd}/Report" -projectPath="${wd}/KatalonAndroidSample.prj" -consoleLog -noSplash -retry=0 -testSuitePath="Test Suites/Sample Test" -remoteWebDriverType="Appium" -executionProfile="default" -remoteWebDriverUrl="http://localhost:4723/wd/hub" -browserType="Remote"
$ cd "$wd"
```

## Test via Android execution

[log directory](/Reports/Sample%20Test/20181015_171402)

Open the project with Katalon Studio and run `Sample Test`.

