package _02_Selenium_Automation_Techniques__Dynamic_XPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;

public class _06_AlertTest_Work_With_Alerts
{
	public static WebDriver driver;

	public WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup, assign it to 'static'
		// variable and return it
		driver = _06_DriverSetup_Work_With_Alerts.getWebDriver();
		return driver;
	}

	public Alert getAlertElement(WebDriver driver) // DO NOT change the method signature
	{
		// Find the 'click' buttton and click it.
		// Locate the 'Alert' element and return it
		driver.findElement(By.name("submit")).click();
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public static void main(String[] args) throws InterruptedException // DO NOT change the method signature
	{
		_06_AlertTest_Work_With_Alerts at = new _06_AlertTest_Work_With_Alerts();
		// Implement code here
		driver = at.createDriver();
		Alert alertMsg = at.getAlertElement(driver);
		System.out.println(alertMsg.getText());
		driver.close();
	}
}
