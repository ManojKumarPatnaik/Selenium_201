package _02_Selenium_Automation_Techniques__Dynamic_XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _05_NameLocator_xPathAncestor {
	// Use the declared variables for stroing required values
	static String fName;
	static WebDriver driver;

	public WebDriver setupDriver() // DO NOT Change the method Signature
	{
		/* Replace this comment by the code statement to create and return the driver */
		/* Naviaget to the url 'http://webapps.tekstac.com/AddressBook/' */
		driver = _05_DriverSetup_xPathAncestor.getWebDriver();
		driver.navigate().to("http://webapps.tekstac.com/AddressBook/");
		return driver;
	}

	public String getNameLocator() // DO NOT Change the method Signature
	{
		/*
		 * Using the driver, Find the element ancestor and its text and assign the text
		 * to 'fName'
		 */
		/* Close the driver */
		driver = setupDriver();
		List<WebElement> dateBox = driver.findElements(By.xpath("//td[text()='NickName']/ancestor::div"));
		fName = "";
		for (WebElement webElement : dateBox) {
//			System.out.println(webElement.getText());
			fName += webElement.getText();
		}

		driver.close();
		return fName;
	}

	public static void main(String[] args) {
		_05_NameLocator_xPathAncestor namLocator = new _05_NameLocator_xPathAncestor();
		// Add required code here
//		driver = _05_DriverSetup_xPathAncestor.getWebDriver();
		String name = namLocator.getNameLocator();
		System.out.println(name);
	}
}
