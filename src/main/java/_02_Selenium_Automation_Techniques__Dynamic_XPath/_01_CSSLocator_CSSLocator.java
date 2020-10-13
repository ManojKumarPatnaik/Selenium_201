package _02_Selenium_Automation_Techniques__Dynamic_XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Add required imports

public class _01_CSSLocator_CSSLocator
{
	static WebDriver driver;

	public WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup and return it
		driver = _01_DriverSetup_CSSLocator.getWebDriver();
		return driver;
	}

	public WebElement getCSSLocator(WebDriver driver) // DO NOT change the method signature
	{
		/*
		 * Replace this comment by the code statement to get the Web element of username
		 */
		/* Find and return the element */
		WebElement usrname = driver.findElement(By.cssSelector("input[id=username]"));
		return usrname;

	}

	public String getName(WebElement element) // DO NOT change the method signature
	{
		// Get the attribute value from the element and return it
		return element.getAttribute("placeholder");
	}

	public static void main(String[] args) {
		_01_CSSLocator_CSSLocator pl = new _01_CSSLocator_CSSLocator();
		// Add required code
		driver = pl.createDriver();
		String uName = pl.getName(pl.getCSSLocator(driver));
		System.out.println("The name is " + uName);
		driver.close();
	}
}
