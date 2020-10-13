package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CC_AddressBook_Address_Book__Basic_Web_Elements { // DO NOT change the class name

	static WebDriver driver;

	public WebDriver createDriver() {
		// Create driver, store in in static variable 'driver' and return it
		driver = CC_DriverSetup_Address_Book__Basic_Web_Elements.getWebDriver();
		return driver;
	}

	public void setNewFormValues(String nickname, String contact, String company, String city, String country,
			String type) {
		// Find the form elements and set values by passing those values from 'main'
		// method.
		// Submit form to add the details
		driver.findElement(By.id("nickname")).sendKeys(nickname);
		driver.findElement(By.id("contact")).sendKeys(contact);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("country")).sendKeys(country);
		driver.findElement(By.id("type")).sendKeys(type);

		driver.findElement(By.id("add")).click();
	}

	public WebElement getNewNickName() {
		// Find and return the 'nickname' web element of the row displayed after first
		// submit

		return driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[1]"));
	}

	public WebElement getNewContact() {
		// Find and return the 'contact' web element of the row displayed after first
		// submit
		return driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[2]"));
	}

	public WebElement getNewCompany() {
		// Find and return the 'company' web element of the row displayed after first
		// submit
		return driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[3]"));
	}

	public WebElement getNewCity() {
		// Find and return the 'city' web element of the row displayed after first
		// submit
		return driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[4]"));
	}

	public WebElement getNewCountry() {
		// Find and return the 'country' web element of the row displayed after first
		// submit
		return driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[5]"));
	}

	public WebElement getNewType() {
		// Find and return the 'type' web element of the row displayed after first
		// submit
		return driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]/td[6]"));
	}

	public void editDetails() {
		// Find the first radio button and click
		// Find edit button and click
		driver.findElement(By.id("radio0")).click();
		driver.findElement(By.id("edit")).click();
	}

	public String getEditNickName() {
		// Find and return the 'nickname' value in the edit box in the form after
		// cicking edit
		return driver.findElement(By.id("nickname")).getAttribute("value");
	}

	public String getEditContact() {
		// Find and return the 'contact' value in the edit box in the form after cicking
		// edit
		return driver.findElement(By.id("contact")).getAttribute("value");
	}

	public String EditNewCompany() {
		// Find and return the 'company' value in the edit box in the form after cicking
		// edit
		return driver.findElement(By.id("company")).getAttribute("value");
	}

	public String getEditCity() {
		// Find and return the 'city' value in the edit box in the form after cicking
		// edit
		return driver.findElement(By.id("city")).getAttribute("value");
	}

	public String getEditCountry() {
		// Find and return the 'country' value in the edit box in the form after cicking
		// edit
		return driver.findElement(By.id("country")).getAttribute("value");
	}

	public String getEditType() {
		// Find and return the 'type' value in the edit box in the form after cicking
		// edit
		return driver.findElement(By.id("type")).getAttribute("value");
	}

	public void setUpdateFormValues(String nickname, String contact, String company, String city, String country,
			String type) {
		// Set form values to update and submit (by passing those values from 'main'
		// method).

		driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys(nickname);

		driver.findElement(By.id("contact")).clear();
		driver.findElement(By.id("contact")).sendKeys(contact);

		driver.findElement(By.id("company")).clear();
		driver.findElement(By.id("company")).sendKeys(company);

		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(city);

		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys(country);

		driver.findElement(By.id("type")).clear();
		driver.findElement(By.id("type")).sendKeys(type);

		driver.findElement(By.id("add")).click();
	}

	public void deleteDetails() {
		// Find the SECOND row of address displayed and click the radio button
		// Find delete button and click to delete SECOND row
		driver.findElement(By.id("radio1")).click();
		driver.findElement(By.id("delete")).click();
	}

	public static void main(String[] args) {
		CC_AddressBook_Address_Book__Basic_Web_Elements ab = new CC_AddressBook_Address_Book__Basic_Web_Elements();
		// Add required code
		driver = ab.createDriver();
		ab.setNewFormValues("VT", "Vijay Tomar", "CTS", "Pune", "India", "Private");

		ab.editDetails();
		ab.setUpdateFormValues("ST", "Sanjay Tomar", "TCS", "Amsterdam", "Netherlands", "Public");

		ab.setNewFormValues("NK", "Nitin Kumar", "LIC", "Delhi", "India", "Govrnment");
		ab.deleteDetails();

		driver.close();

		System.out.println("<[Program completed !!!]>");
	}
}
