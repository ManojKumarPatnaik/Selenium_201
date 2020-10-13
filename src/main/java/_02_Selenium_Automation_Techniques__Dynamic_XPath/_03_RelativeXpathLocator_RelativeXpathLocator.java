package _02_Selenium_Automation_Techniques__Dynamic_XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Add required imports

public class _03_RelativeXpathLocator_RelativeXpathLocator
{
	static WebDriver driver;

	public WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup and return it
		return _03_DriverSetup_RelativeXpathLocator.getWebDriver();
	}

	public WebElement getRelativeXpathLocator(WebDriver driver)// DO NOT change the method signature
	{
		/* Replace this comment by the code statement to get the Web element */
		/* Find and return the element */
		return driver.findElement(By.xpath("//*[@id=\"tbrow\"]/td[3]"));
	}

	public String getName(WebElement element)// DO NOT change the method signature
	{
		// Get the attribute value from the element and return it
		return element.getText();
	}

	public static void main(String[] args) {
		_03_RelativeXpathLocator_RelativeXpathLocator pl = new _03_RelativeXpathLocator_RelativeXpathLocator();
		// Add required code
		driver = pl.createDriver();
		String name = pl.getName(pl.getRelativeXpathLocator(driver));
		System.out.println("The value is " + name);
		driver.close();
	}
}
