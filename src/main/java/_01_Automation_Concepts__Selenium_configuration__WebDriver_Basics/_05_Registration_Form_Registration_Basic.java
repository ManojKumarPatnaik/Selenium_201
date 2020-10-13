package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class _05_Registration_Form_Registration_Basic {
	String fName;
	static WebDriver driver;
	static String baseUrl = "http://webapps.tekstac.com/Shopify/";

	public WebDriver setupDriver() {

		/*
		 * Invoke the getWebDriver method Set value of BaseUrl Launch the app using
		 * get() with baseUrl
		 */
		driver = _05_DriverSetup_Form_Registration_Basic.getWebDriver();
		driver.get(baseUrl);
		return driver;
	}

	public void setElements() {
		/*
		 * Using the driver, Find the elements by id Set the values to the elements
		 * Register the form
		 */
		driver.findElement(By.id("firstname")).sendKeys("Rahul");
		driver.findElement(By.id("lastname")).sendKeys("Dravid");
		driver.findElement(By.id("username")).sendKeys("Rahul Dravid");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("reg")).click();
	}

	public static void main(String[] args) {
		_05_Registration_Form_Registration_Basic reg = new _05_Registration_Form_Registration_Basic();
		/* Implement the code here */
		driver = reg.setupDriver();
		reg.setElements();
		driver.close();
	}
}
