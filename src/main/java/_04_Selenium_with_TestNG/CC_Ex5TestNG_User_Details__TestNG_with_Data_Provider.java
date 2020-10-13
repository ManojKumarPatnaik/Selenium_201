package _04_Selenium_with_TestNG;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import junit.framework.Assert;

//@Listeners(FeatureTest.class) // DO NOT remove or alter this line. REQUIRED FOR TESTING
public class CC_Ex5TestNG_User_Details__TestNG_with_Data_Provider
{

	static WebDriver driver;
	static String[][] excelData = null;

	@BeforeSuite
	public void createDriver() // DO NOT change the method signature
	{
		// Create driver and assign it to 'static' driver variable
		driver = CC_DriverSetup_User_Details__TestNG_with_Data_Provider.getWebDriver();
	}

	@DataProvider(name = "Users")
	public Object[][] usersData() throws IOException {
		// Parse data from Users.xlsx, store in excelData variable and return the
		// 2-dimensional array
		String inputFile = System.getProperty("user.dir") + File.separator + "Users.xlsx";

		Integer lastRow = null;
		short lastCol = 0;
		excelData = null;
		FileInputStream file = new FileInputStream(inputFile);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("users");

		XSSFRow row;
		XSSFCell cell;
		lastRow = sheet.getPhysicalNumberOfRows();
		lastCol = sheet.getRow(0).getLastCellNum();

		excelData = new String[lastRow][lastCol];
//		System.out.println(sheet.getPhysicalNumberOfRows());

		for (int r = 0; r < lastRow; r++) {
			row = (XSSFRow) sheet.getRow(r);
			if (row != null) {
				for (int c = 0; c < lastCol; c++) {
					cell = row.getCell(c);
					if (cell == null) {
						excelData[r][c] = "";
					} else {
						excelData[r][c] = new DataFormatter().formatCellValue(cell);
					}
				}
			}
		}
		workbook.close();
		return excelData;
	}

	@Test(dataProvider = "Users")
	void testUser(String Uname, String Uaddr, String Uphoneno, String Uemail) throws InterruptedException // DO NOT
																											// change
																											// the
																											// method
																											// signature
	{
		// Fill the form using data parsed from excel and submit
		// Test the user details data against the excel data as specified in
		// description.
		// This MUST happen for 2 rows in excel
		
		WebElement u = driver.findElement(By.id("name"));
		WebElement a = driver.findElement(By.id("address"));
		WebElement m = driver.findElement(By.id("mobile"));
		WebElement e = driver.findElement(By.id("email"));
		WebElement b = driver.findElement(By.id("Submit"));

		u.clear();
		u.sendKeys(Uname);
		a.clear();
		a.sendKeys(Uaddr);
		m.clear();
		m.sendKeys(Uphoneno);
		e.clear();
		e.sendKeys(Uemail);
		b.click();

		String uname = driver.findElement(By.xpath("//*[@id='result']")).getText().split("\n")[0].split(":")[1];
		String address = driver.findElement(By.xpath("//*[@id='result']")).getText().split("\n")[1].split(":")[1];
		String phone = driver.findElement(By.xpath("//*[@id='result']")).getText().split("\n")[2].split(":")[1];
		String email = driver.findElement(By.xpath("//*[@id='result']")).getText().split("\n")[3].split(":")[1];

		Assert.assertEquals("Name doesn't match", Uname, uname);
		Assert.assertEquals("Address doesn't match", Uaddr, address);
		Assert.assertEquals("Mobile Number doesn't match", Uphoneno, phone);
		Assert.assertEquals("E-mail Id doesn't match", Uemail, email);

	}

	public void checkUser() { // DO NOT change the method signature
		// Invoke the test using TestNG ONLY HERE.
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { CC_Ex5TestNG_User_Details__TestNG_with_Data_Provider.class });
		testSuite.run();
	}

	public static void main(String[] args) throws InterruptedException {
		CC_Ex5TestNG_User_Details__TestNG_with_Data_Provider ex5 = new CC_Ex5TestNG_User_Details__TestNG_with_Data_Provider();
		// Add required code here
		ex5.createDriver();
		ex5.checkUser();
		driver.close();
	}
}
