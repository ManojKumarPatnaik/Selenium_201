package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _02_PageLocator_IdLocator
{
	static WebDriver driver;
	String lastName;
	WebElement lName;

	public WebDriver createDriver() // DO NOT change the method signature
	{
		driver = _02_DriverSetup_IdLocator.getWebDriver();
		return driver;
	}

	public WebElement getPageLocator(WebDriver driver) // DO NOT change the method signature
	{
		lName = createDriver().findElement(By.id("lastname"));
		return lName;
	}

	public String getName(WebElement element) // DO NOT change the method signature
	{
		lastName = element.getAttribute("placeholder");
		return lastName;
	}

	public static void main(String[] args) {
		_02_PageLocator_IdLocator pl = new _02_PageLocator_IdLocator();
		WebElement name = pl.getPageLocator(driver);
		String lName = pl.getName(name);
		System.out.println("The name is " + lName);
	}
}
