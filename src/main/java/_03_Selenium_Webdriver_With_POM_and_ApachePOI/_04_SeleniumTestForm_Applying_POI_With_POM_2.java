package _03_Selenium_Webdriver_With_POM_and_ApachePOI;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class _04_SeleniumTestForm_Applying_POI_With_POM_2 { // DO NOT change the class name

	// Use this declarations to store respective values
	public static WebDriver driver;
	public static String result;
	public static String msg;

	public void createDriver() {
		// Implement code to create driver and assign it to 'static' driver variable
		driver = _04_DriverSetup_Applying_POI_With_POM_2.getWebDriver();
	}

	public void testSeleniumTestForm(String weight, String transportMode) throws Exception {
		// 'weight' and 'transportMode' parameter are used to send the values to the
		// form
		// find the elements in the form and set values as per description. Submit the
		// form.
		// Find the element of the message displayed after submit. Store it in 'msg'
		// variable.
		// Store the 'pass' or 'fail' in the 'result' variable
		WebElement w = driver.findElement(By.id("weight"));
		WebElement t = driver.findElement(By.id(transportMode));
		WebElement b = driver.findElement(By.id("calculate"));
		WebElement r = driver.findElement(By.id("result"));

		w.sendKeys(weight);
		t.click();
		b.click();
		msg = r.getText();

		if (msg.equals("Dear Customer, your total shipping cost is $200")) {
			result = "pass";
		} else {
			result = "fail";
		}
	}

	public void closeBrowser() {
		// close the browser
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		_04_SeleniumTestForm_Applying_POI_With_POM_2 st = new _04_SeleniumTestForm_Applying_POI_With_POM_2();
		// Add code here
		st.createDriver();
		st.testSeleniumTestForm("200", "air");
		_04_CargoShipping_Applying_POI_With_POM_2.writeExcelData("cargo.xlsx", result);
		st.closeBrowser();
	}
}
