package com.hyder.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {

	public static ExtentReports extent;
	public static ExtentTest test;

	// Start Test Case
	public void startTest(String testCaseName, String featureName) {

	/**Create ExtentReports object passing location and report name as argument.
	 * Notice a new Result Log folder will be created inside project and the 
	 * report name will be TestReport.html
	 */
		extent = new ExtentReports(Constants.sReportFileName, false);

		// Add details to our report
		extent.addSystemInfo("Selenium Version", "3.141.59").addSystemInfo("Environment", "QA");

		// Create ExtentTest passing test case name and description
		test = extent.startTest(testCaseName, featureName);
	}

	// Log Test status, Test name and Test details
	public void logStatus(LogStatus testStatus, String testStepName, String testDetails) {

		// Log test status
		test.log(testStatus, testStepName, testDetails);
	}

	// Capture screenshot and log into report
	public void screenshotLog(LogStatus logStatus, String testStepName, String screenShotPath) {

		// Attach screenshots
		test.log(logStatus, testStepName + test.addScreenCapture(screenShotPath));
	}

	// End Test Case
	public void endTest() {

		// End test
		extent.endTest(test);
		extent.flush();
		extent.close();
	}
}