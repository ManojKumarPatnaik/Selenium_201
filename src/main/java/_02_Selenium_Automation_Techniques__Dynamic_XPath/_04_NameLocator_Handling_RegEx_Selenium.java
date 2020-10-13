package _02_Selenium_Automation_Techniques__Dynamic_XPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _04_NameLocator_Handling_RegEx_Selenium { // DO NOT change the class name

	public static String baseUrl = "http://webapps.tekstac.com/Handling_Regular_Expression/"; // Assign
																								// 'http://webapps.tekstac.com/Handling_Regular_Expression/'
																								// for baseUrl
	public static WebDriver driver;

	public WebDriver createDriver() {
		// Create driver. Assign it to static variable 'driver' and return it
		return _04_DriverSetup_Handling_RegEx_Selenium.getWebDriver();
	}

	public void navigate(WebDriver driver) {
		// Navigate to the baseUrl
		driver.navigate().to(baseUrl);
	}

	public void setFormValues(WebDriver driver) {
		// set the value for 'Shipment for user' and submit form
		driver.findElement(By.id("userId")).sendKeys("Shamili");
		driver.findElement(By.id("track")).click();
	}

	public WebElement getNameResultElement(WebDriver driver) {
		// Find the element of 'Shamili' and return it
		return driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[1]/td[2]"));
	}

	public WebElement getShipmentResultElement(WebDriver driver) {
		// Find the element of 'SHIP1236' and return it
		return driver.findElement(By.id("shipment"));
	}

	public WebElement getEmailResultElement(WebDriver driver) {
		// Find the element of 'shamili93@gamil.com' and return it
		return driver.findElement(By.id("e- mail"));
	}

	public boolean validateEmail(String eMailID) {
		// Validate email using regex.
		String mailRegExp = "\\b[A-Z0-9a-z-]+@[a-z]+\\.[a-z]{2,4}\\b";
		if (eMailID.matches(mailRegExp)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateShipmentId(String shipmentId) {
		// Validate shipmentId using regex
		String shipmentRegExp = "[A-Z0-9]{8}";
		if (shipmentId.matches(shipmentRegExp)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		_04_NameLocator_Handling_RegEx_Selenium reg = new _04_NameLocator_Handling_RegEx_Selenium();
		// Add required code here
		driver = reg.createDriver();
		reg.navigate(driver);
		reg.setFormValues(driver);

		WebElement name = reg.getNameResultElement(driver);

		boolean email_validation = reg.validateEmail(reg.getEmailResultElement(driver).getText());
		boolean shipment_validation = reg.validateEmail(reg.getShipmentResultElement(driver).getText());

		System.out.println("Email validation : " + email_validation);
		System.out.println("Shipment Id validation : " + shipment_validation);

		driver.close();
	}
}
