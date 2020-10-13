package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class _03_Registration_All_Webelements
{
	static WebDriver driver;
	static String baseUrl; // Assign the value for baseUrl

	public WebDriver createDriver() // DO NOT change the method signature
	{
		driver = _03_DriverSetup_All_Webelements.getWebDriver();
		return driver;
	}

	public void navigate(WebDriver driver) // DO NOT change the method signature
	{
		baseUrl = "http://webapps.tekstac.com/InvoiceUpdates/";
		driver.get(baseUrl);
	}

	public Select getCategoryElement(WebDriver driver) // DO NOT change the method signature
	{
		WebElement testDropDown = driver.findElement(By.xpath("//select"));
		Select dropdown = new Select(testDropDown);
		dropdown.selectByValue("utility invoice");

		return dropdown;
	}

	public void setFormValues(WebDriver driver) // DO NOT change the method signature
	{
		driver.findElement(By.id("name")).sendKeys("Rakesh");
		driver.findElement(By.id("number")).sendKeys("123");
		driver.findElement(By.id("newUser")).click();
		
		WebElement ddl = driver.findElement(By.xpath("//select"));
		Select dropdown = new Select(ddl);
		dropdown.selectByValue("utility invoice");
		
		driver.findElement(By.name("amount")).sendKeys("1000");
		driver.findElement(By.name("num")).sendKeys("9876543210");
		driver.findElement(By.name("comments")).sendKeys("New User Invoice");
		driver.findElement(By.id("submit")).submit();
	}

	public WebElement getSuccessMessageElement(WebDriver driver) // DO NOT change the method signature
	{
		return driver.findElement(By.id("result"));
	}

	public String getSuccessMessage(WebElement element) // DO NOT change the method signature
	{
		return element.getText();
	}

	public static void main(String[] args) {
		_03_Registration_All_Webelements reg = new _03_Registration_All_Webelements();
		driver = reg.createDriver();
		reg.navigate(driver);
		Select dd = reg.getCategoryElement(driver);

		reg.setFormValues(driver);
		WebElement we = reg.getSuccessMessageElement(driver);
		String msg = reg.getSuccessMessage(we);
		System.out.println(msg);

		driver.close();
	}
}
