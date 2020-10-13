package _02_Selenium_Automation_Techniques__Dynamic_XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Add required imports

public class _02_AbsoluteXpathLocator_AbsoluteXpathLocator
{
	static WebDriver driver;

	public WebDriver createDriver() {
		// Implement code to create Driver from DriverSetup and return it
		return _02_DriverSetup_AbsoluteXpathLocator.getWebDriver();
	}

	public WebElement getAbsoluteXpathLocator(WebDriver driver)// DO NOT change the method signature
	{
		/* Replace this comment by the code statement to get the Web element of logo */
		/* Find and return the element */
		return driver.findElement(By.xpath("/html/body/form/div[1]/img"));
	}

	public String getName(WebElement element) // DO NOT change the method signature
	{
		// Get the attribute value from the element and return it
		return element.getAttribute("src");
	}

	public static void main(String[] args) {
		_02_AbsoluteXpathLocator_AbsoluteXpathLocator pl = new _02_AbsoluteXpathLocator_AbsoluteXpathLocator();
		// Add required code
		driver = pl.createDriver();
		String src = pl.getName(pl.getAbsoluteXpathLocator(driver));
		System.out.println("The image src is " + src);
		driver.close();
	}
}
