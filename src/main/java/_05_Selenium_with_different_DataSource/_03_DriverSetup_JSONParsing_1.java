package _05_Selenium_with_different_DataSource;
/* IMPORTANT:- DriverSetup --getWebDriver()
-------------------------------------------------
PLEASE DO NOT MAKE ANY CHANGES OR MOFICATIONS IN THIS PROGRAM */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.*;

public class _03_DriverSetup_JSONParsing_1 {
	private static WebDriver driver;

	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\Eclipse_Workspace\\Browser_Drivers\\geckodriver.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary();
//		firefoxBinary.addCommandLineOptions("--headless");
		FirefoxProfile profile = new FirefoxProfile();
		// profile.setPreference("marionette.logging", "TRACE");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		firefoxOptions.setProfile(profile);
		driver = new FirefoxDriver(firefoxOptions);
		String baseUrl = "http://webapps.tekstac.com/AddressBook/";
		driver.get(baseUrl);
		return driver;
	}
}
