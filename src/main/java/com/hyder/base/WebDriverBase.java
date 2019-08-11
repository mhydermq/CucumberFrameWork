package com.hyder.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.hyder.utils.Config;
import com.hyder.utils.Log;



public class WebDriverBase {

	public static WebDriver webDriver;

	//private static final int pageElementLoadWait = 30;
	private static final int pageTimeOutWait = 20;
	private static HashMap<Long, WebDriver> webDriverMap = new HashMap<Long, WebDriver>();
	public static String TCName;
	public static String FeatureName;

	//public static Reports report = new Reports();

    public static WebDriver getDriverInstance() {

	    //report.startTest(Hooks.TCName, Hooks.FeatureName);
        WebDriver driver = webDriverMap.get(Thread.currentThread().getId());
        if (driver == null) {
         	Log.startTestCase(TCName);
          	BasePage.startReport();
            loadWebDriver();
        }
        return webDriverMap.get(Thread.currentThread().getId());
    }

	public static void loadWebDriver() {

		String browser = Config.getProp().getProperty("selenium.browser");
		if(browser.equals("SAFARI")){
 		System.setProperty("webdriver.safari.driver", Config.getProp().getProperty("webdriver.safari.driver"));
			webDriver = new SafariDriver();
		}

		else if(browser.equals("FIREFOX")){
			System.setProperty("webdriver.gecko.driver", Config.getProp().getProperty("webdriver.firefox.driver"));
			webDriver = new FirefoxDriver();
		}

		else if(browser.equals("CHROME")){
			System.setProperty("webdriver.chrome.driver", Config.getProp().getProperty("webdriver.chrome.driver"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);

			webDriver = new ChromeDriver(options);
			//driver.manage().window().maximize();
		}

		//Setting page load time out
		    webDriver.manage().window().maximize();
		    webDriver.manage().timeouts().pageLoadTimeout(pageTimeOutWait, TimeUnit.SECONDS);
		    webDriver.manage().deleteAllCookies();
		    webDriverMap.put(Thread.currentThread().getId(), webDriver);    
	}

	public static void endTest(String TestName) {

		BasePage.endReport();
		Log.endTestCase(TestName);
		webDriverMap.get(Thread.currentThread().getId()).close();
		webDriverMap.get(Thread.currentThread().getId()).quit();
		webDriverMap.remove(Thread.currentThread().getId());
	}
}


