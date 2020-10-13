package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;
/* IMPORTANT:- DriverSetup --getDriver()
-------------------------------------------------
PLEASE DO NOT MAKE ANY CHANGES OR MOFICATIONS IN THIS PROGRAM */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class _02_DriverSetup_IdLocator {
	private static WebDriver driver;

	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\Eclipse_Workspace\\Browser_Drivers\\geckodriver.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
	    FirefoxProfile profile=new FirefoxProfile();
	    //profile.setPreference("marionette.logging", "TRACE");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		firefoxOptions.setProfile(profile);
	    driver=new FirefoxDriver(firefoxOptions);
	    String baseUrl = "http://webapps.tekstac.com/Shopify/";
	    driver.get(baseUrl);
	    return driver;
	}
}
