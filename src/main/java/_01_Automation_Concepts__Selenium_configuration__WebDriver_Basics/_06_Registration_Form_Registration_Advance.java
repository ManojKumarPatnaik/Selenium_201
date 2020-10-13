package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class _06_Registration_Form_Registration_Advance {
	String fName;
	static WebDriver driver;
	static String baseUrl = "http://webapps.tekstac.com/Shopify/";

	public WebDriver setupDriver() {
		driver = _06_DriverSetup_Form_Registration_Advance.getWebDriver();
		driver.get(baseUrl);
		return driver;
	}

	public void setElements() {
		driver.findElement(By.id("firstname")).sendKeys("Mithali");
		driver.findElement(By.id("lastname")).sendKeys("Raj");
		driver.findElement(By.id("username")).sendKeys("Mithali Raj");

		WebElement ddl = driver.findElement(By.id("selectcity"));
		Select dropdown = new Select(ddl);
		dropdown.selectByValue("mas");

		WebElement radio = driver.findElement(By.xpath("//*[@type='radio'][@value='female']"));
		radio.click();

		driver.findElement(By.id("pass")).sendKeys("MR@123");
		driver.findElement(By.id("reg")).click();
	}

	public static void main(String[] args) {
		_06_Registration_Form_Registration_Advance reg = new _06_Registration_Form_Registration_Advance();
		driver = reg.setupDriver();
		reg.setElements();
		driver.close();
	}
}
