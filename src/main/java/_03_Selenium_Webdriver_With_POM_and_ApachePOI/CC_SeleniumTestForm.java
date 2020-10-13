package _03_Selenium_Webdriver_With_POM_and_ApachePOI;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CC_SeleniumTestForm { // DO NOT change the class name

	public static WebDriver driver;
	public static String result1; // Store the message displayed on the page after submit
	public static String msg1 = "Dear Customer, your total shipping cost is $200";
	public static String msg2 = "Dear Customer, your total shipping cost is $50";

	public void createDriver() {
		// Create driver and store in in static variable 'driver'
		driver = CC_DriverSetup.getWebDriver();
	}

	public void testSeleniumTestForm(String weight, String transportMode) throws Exception {
		// Pass the weight and transpot mode read from excel sheet to this method.
		// Send these data to form and submit.
		// Retrieve the message displayed on page after submit. Store it in variable
		// 'result1'
		// Assert the message retrieved with expected.
		// Write the data, message retrieved and "Test Passed" or "Test Failed" to a new
		// sheet 'customervalid1'
		WebElement w = driver.findElement(By.id("weight"));
		WebElement t = driver.findElement(By.id(transportMode));
		WebElement b = driver.findElement(By.id("calculate"));
		WebElement r = driver.findElement(By.id("result"));

		w.clear();
		w.sendKeys(weight);
		t.click();
		b.click();
		result1 = r.getText();
//		System.out.println(result1);
	}

	public static void main(String[] args) throws Exception {
		CC_SeleniumTestForm st = new CC_SeleniumTestForm();
		// Add code here
		st.createDriver();

		CC_CargoShipping.getExcelPath("customervalid1");

		st.testSeleniumTestForm("200", "air");
		String msg = null;
		if (result1.equals(msg1)) {
			msg = "true";
		} else {
			msg = "false";
		}
		CC_CargoShipping.writeExcelData("customervalid1", result1, msg, 0);

		st.testSeleniumTestForm("100", "road");
		if (result1.equals(msg2)) {
			msg = "true";
		} else {
			msg = "false";
		}
		CC_CargoShipping.writeExcelData("customervalid1", result1, msg, 1);

		CC_CargoShipping.readExcelData("customervalid1");
		driver.close();
		System.out.println("<[Program Completed !!!]>");
	}
}
