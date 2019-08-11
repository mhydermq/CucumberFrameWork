package com.hyder.base;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import com.hyder.utils.Config;
import com.hyder.utils.Constants;
import com.hyder.utils.Log;
import com.hyder.utils.Reports;
import com.hyder.base.WebDriverBase;

public class BasePage {

	public WebDriver driver;
	private static final int pageElementLoadWait = 30;
	private static final int pageTimeOutWait = 20;
	public static Reports report = new Reports();
	public static HashMap<WebElement, String> elementDetails = new HashMap<WebElement, String>();

	public BasePage(){
		PageFactory.initElements(WebDriverBase.getDriverInstance(), this);
		driver = WebDriverBase.getDriverInstance();
		waitForPagetoLoad(pageTimeOutWait);
		Log.info("Page Factory initialized");
	}

    public void waitForPagetoLoad(int timeOut) {
        if (timeOut > 0) {
        	WebDriverBase.getDriverInstance().manage().timeouts()
                    .pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        }
    }

	// Wait for Element to be clickable
	public WebElement waitForElement(WebElement element) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, pageElementLoadWait);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Log.info("Wait for element "+ elementDetails.get(element));
			return element;
		}catch(Exception e){
			
		}
		return null;
	}

	// Navigate to URL
	public void navigateToURL(String siteURL) {
		driver.navigate().to(siteURL);
		report.logStatus(LogStatus.PASS, "OpenBrowser: " 
		+ Config.getProp().getProperty("selenium.browser") + "," + siteURL,"Passed");
		Log.info("Demo URL Launched");
	}

   // Take a screenshot
	public void takeScreenShot(String fileName) {

		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(Constants.sScreenshotFilepath + fileName + ".png")); //.jpeg"));
			Log.info("Screenshot captured");
		} catch (Exception e) {

			System.out.println(e.getMessage());
			Log.info("Screenshot exception");
		}
	}

	// Start Extent Reporting
	public static void startReport() {
		report.startTest(WebDriverBase.TCName, WebDriverBase.FeatureName);
	}

	// End Extent Reporting
	public static void endReport() {
		report.endTest();
	}
	
	// End a Test
	public void endTest() {
		driver.close();
		driver.quit();
	}
	
	/*Click Element method.
	 * This method will log in Extent Report as well in Log4j.
	*/

	public boolean clickElement(WebElement element) {
		try {
			element = waitForElement(element);
			if (element != null) {
				
				takeScreenShot(elementDetails.get(element));
				report.logStatus(LogStatus.PASS, "Click",
						"Click " + elementDetails.get(element) + " <span class='label success'>Success</span>");
				report.screenshotLog(LogStatus.PASS, "Click Success " + elementDetails.get(element),
						Constants.sScreenshotFilepath + elementDetails.get(element) + ".png"); //.jpeg");
				Log.info("Element Clicked: "+elementDetails.get(element));
				element.click();
				return true;
			}

			else
				throw new NoSuchElementException("Element not found");

		} catch (Exception e) {

			takeScreenShot("Fail_" + Constants.dateTag);
			report.screenshotLog(LogStatus.FAIL, "Click Failed ",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png"); //.jpeg");
			Log.info("Element Click Exception");
			report.endTest();
			throw new NoSuchElementException("Element not found");
		}
	}

	

	/**Enter text in text box method.
	 * This method will log in Extent Report as well in Log4j.
	 * 
	 */

	public boolean EnterText(WebElement element, String input) {
		try {
			element = waitForElement(element);
			if (element != null) {
				element.sendKeys(input);
				report.logStatus(LogStatus.PASS, "Enter Text",
						"Enter Text into " + elementDetails.get(element) 
						+ " <span class='label success'>Success</span>");

				Log.info("Enter text: " + elementDetails.get(element));
				return true;
			}else

				throw new NoSuchElementException("Element not found");
		} catch (Exception e) {

			takeScreenShot("Fail_" + Constants.dateTag);
			report.screenshotLog(LogStatus.FAIL, "Enter Text",
					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png"); //.jpeg");
			Log.info("Enter text Exception");
			throw new NoSuchElementException("Element not found");
		}	
	}

	/**Select a value from drop down by text method.
	 * This method will log in Extent Report as well in Log4j.
	 */

	public boolean SelectElementByText(WebElement element, String input) {
		try {

			element = waitForElement(element);
			if (element != null) {

				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(input);
				report.logStatus(LogStatus.PASS, "Select Element", "Select Element For " + elementDetails.get(element)
						+ " <span class='label success'>Success</span>");

				Log.info("Select element: " + elementDetails.get(element));
				return true;
			}else

				throw new NoSuchElementException("Element not found");
		} catch (Exception e) {

			takeScreenShot("Fail_" + Constants.dateTag);
			report.screenshotLog(LogStatus.FAIL, "Select Element",

					Constants.sScreenshotFilepath + "Fail_" + Constants.dateTag + ".png"); //.jpeg");
			Log.info("Select element Exception ");

			throw new NoSuchElementException("Element not found");
		}
	}
}
