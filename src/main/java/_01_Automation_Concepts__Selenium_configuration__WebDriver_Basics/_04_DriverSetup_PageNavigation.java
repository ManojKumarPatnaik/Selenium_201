package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;
/* IMPORTANT:- DriverSetup --getDriver()
-------------------------------------------------
PLEASE DO NOT MAKE ANY CHANGES OR MOFICATIONS IN THIS PROGRAM */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class _04_DriverSetup_PageNavigation {
	private static WebDriver driver;

	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\Eclipse_Workspace\\Browser_Drivers\\geckodriver.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
	    FirefoxProfile profile=new FirefoxProfile();
	    FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		firefoxOptions.setProfile(profile);
	    driver=new FirefoxDriver(firefoxOptions);
	    return driver;
	}
}
