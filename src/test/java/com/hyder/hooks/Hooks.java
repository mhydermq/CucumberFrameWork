package com.hyder.hooks;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.hyder.base.WebDriverBase;
import com.hyder.utils.Config;
import com.hyder.utils.Constants;
import com.hyder.utils.Reports;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static Reports report;

	//hooks run before the first step of each scenario
	@Before
	public void setUp(Scenario scenario){

	     // initialize the driver
		 System.setProperty(Config.getProp().getProperty("logfoldername"), Constants.logFolderName);
		 System.setProperty(Config.getProp().getProperty("logfilename"), Constants.logFileName);
		 DOMConfigurator.configure("src/main/java/com/hyder/utils/log4j.xml");
		 WebDriverBase.TCName = scenario.getName();
		 WebDriverBase.FeatureName = scenario.getId().split(";")[0];
	     WebDriverBase.getDriverInstance();
	}
	   
	//hooks run after the last step of each scenario
	@After
	public void tearDown(Scenario scenario){

	try{
			if(scenario.isFailed()){
				final byte[] screenshot = ((TakesScreenshot)WebDriverBase.getDriverInstance()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		} finally{
			
			if(WebDriverBase.getDriverInstance().getWindowHandles().size()>0){
		        System.out.println("closing the browser!");
		        WebDriverBase.endTest(scenario.getName());
			}
		}
	}
}
