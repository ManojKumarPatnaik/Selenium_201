package _03_Selenium_Webdriver_With_POM_and_ApachePOI;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;

public class _03_SeleniumTestForm_Applying_POI_With_POM_1 { // Do not change the class name

	public static WebDriver driver;

	public void createDriver() { // Do not change the method signature
		// Implement code to create driver and assign it to 'static' driver variable
		driver = _03_DriverSetup_Applying_POI_With_POM_1.getWebDriver();
	}

	public void testSeleniumTestForm() { // Do not change the method signature
		// Read the data from excel sheet. Sheet name is 'customervalid'
		// find the elements in the form and set values parsed from excel sheet. Submit
		// the form for registration

		driver.findElement(By.name("cname")).sendKeys(_03_CusRegExcel_Applying_POI_With_POM_1.customerData[0]);
		driver.findElement(By.name("age")).sendKeys(_03_CusRegExcel_Applying_POI_With_POM_1.customerData[1]);
		driver.findElement(By.name("address")).sendKeys(_03_CusRegExcel_Applying_POI_With_POM_1.customerData[2]);
		driver.findElement(By.name("phonenumber")).sendKeys(_03_CusRegExcel_Applying_POI_With_POM_1.customerData[3]);
		driver.findElement(By.name("email")).sendKeys(_03_CusRegExcel_Applying_POI_With_POM_1.customerData[4]);
		driver.findElement(By.id("submit")).submit();
	}

	public void closeBrowser() {
		// close the browser
		driver.close();
	}

	public static void main(String[] args) {
		_03_CusRegExcel_Applying_POI_With_POM_1 customer = new _03_CusRegExcel_Applying_POI_With_POM_1();
		// Add required code

		_03_SeleniumTestForm_Applying_POI_With_POM_1 stf = new _03_SeleniumTestForm_Applying_POI_With_POM_1();
		stf.createDriver();

		_03_CusRegExcel_Applying_POI_With_POM_1.readExcelData("CustReg.xlsx");

		stf.testSeleniumTestForm();
		stf.closeBrowser();

		System.out.println("<[Program Completed !!!]>");
	}
}
