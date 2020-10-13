package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class _01_NameLocator_Object_Identification_By_name {
	String fName;
	static WebDriver driver;

	public WebDriver setupDriver() {
		/* Invoke the getWebDriver method from the DriverSetup File */
		driver = _01_DriverSetup_Object_Identification_By_name.getWebDriver();
		return driver;
	}

	public String getNameLocator() {
		/*
		 * Identify the Firstname Get the placeholder value Store the placeholder value
		 * in the static variable fName.
		 */
		driver = setupDriver();
		fName = driver.findElement(By.name("fname")).getAttribute("placeholder");
		driver.close();

		return fName;
	}

	public static void main(String[] args) {
		/*start */
		_01_NameLocator_Object_Identification_By_name namLocator = new _01_NameLocator_Object_Identification_By_name();
		String name = namLocator.getNameLocator();
		System.out.println("The name is " + name);
	}

}
