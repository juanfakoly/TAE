# TRIVAGO TEST

## HOW RUN IT

first you need finding the file here `src/test/resources/SuiteTest.xml` and run the test from here.

Make sure that capabilities are ready in the following path: `src/test/resources/mobile_capabilities.json`

```JSON
{
	"deviceName": "",
	"platformName": "",
	"platformVersion": "",
	"appPackage": "",
	"appActivity": "",
	"noReset": ""
}
```

- IS NECESSARY SET EVERY VALUE TO THESE CAPABILITIES AND THE VALUE OF `noReset` CAPABILITIE SHOULD BE __TRUE__

__it is necessary after executing restart the appium session__ 