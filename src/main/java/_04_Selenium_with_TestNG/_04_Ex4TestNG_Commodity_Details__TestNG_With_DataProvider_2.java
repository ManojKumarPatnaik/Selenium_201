package _04_Selenium_with_TestNG;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import junit.framework.Assert;

//@Listeners(FeatureTest.class) // DO NOT remove or alter this line. REQUIRED FOR TESTING
public class _04_Ex4TestNG_Commodity_Details__TestNG_With_DataProvider_2
{
	WebDriver driver;
	XSSFSheet testSheet;
	static int testCount = 1;

	@BeforeSuite
	public void createDriver() { // DO NOT change the method signature
		// Create driver and assign it to 'static' driver variable
		driver = _04_DriverSetup_Commodity_Details__TestNG_With_DataProvider_2.getWebDriver();
	}

	@DataProvider(name = "commodityData")
	public Object[][] commodityData() throws IOException {
		// Parse data from CommodityDetails.xlsx and return the 2-dimensional array
		String inputFile = System.getProperty("user.dir") + File.separator + "CommodityDetails.xlsx";

		Integer lastRow = null;
		short lastCol = 0;
		Object[][] sheetData = null;
		FileInputStream file = new FileInputStream(inputFile);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Data");

		XSSFRow row;
		XSSFCell cell;
		lastRow = sheet.getPhysicalNumberOfRows();
		lastCol = sheet.getRow(1).getLastCellNum();

		sheetData = new Object[lastRow - 1][lastCol];
//		System.out.println(sheet.getPhysicalNumberOfRows());

		for (int r = 0; r < lastRow; r++) {
			row = (XSSFRow) sheet.getRow(r + 1);
			if (row != null) {
				for (int c = 0; c < lastCol; c++) {
					cell = row.getCell(c);
					if (cell == null) {
						sheetData[r][c] = "";
					} else {
						sheetData[r][c] = new DataFormatter().formatCellValue(cell);
					}
				}
			}
		}
		workbook.close();
		return sheetData;
	}

	@Test(dataProvider = "commodityData")
	void testCommodity(String name, String weight, String length, String width, String height)
			throws InterruptedException {
		// Pass the form data parsed from excel sheet and submit form
		// Find the elements of the newly displayed row on the page and compare the
		// values against the excel data as mentioned in the description

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("weight")).sendKeys(weight);
		driver.findElement(By.id("length")).sendKeys(length);
		driver.findElement(By.id("width")).sendKeys(width);
		driver.findElement(By.id("height")).sendKeys(height);

		driver.findElement(By.id("add")).click();

		WebElement htmltable = driver.findElement(By.xpath(".//*[@id='myTable']/tbody"));
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
//		for (int r = 1; r < rows.size() - 1; r++) {
//			List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));

		List<WebElement> columns = rows.get(rows.size() - 2).findElements(By.tagName("td"));
		for (int c = 0; c < columns.size(); c++) {
			if (c == 0) {
				Assert.assertEquals("name doesnt match", name, columns.get(c).getText());
			} else if (c == 1) {
				Assert.assertEquals("weight doesnt match", weight, columns.get(c).getText());
			} else if (c == 2) {
				Assert.assertEquals("length doesnt match", length, columns.get(c).getText());
			} else if (c == 3) {
				Assert.assertEquals("width doesnt match", width, columns.get(c).getText());
			} else if (c == 4) {
				Assert.assertEquals("height doesnt match", height, columns.get(c).getText());
			}
		}
//		}
	}

	public void commodity() {
		// Invoke the test using TestNG ONLY HERE.
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { _04_Ex4TestNG_Commodity_Details__TestNG_With_DataProvider_2.class });
		testSuite.run();
	}

	public static void main(String[] args) {
		_04_Ex4TestNG_Commodity_Details__TestNG_With_DataProvider_2 ex4 = new _04_Ex4TestNG_Commodity_Details__TestNG_With_DataProvider_2();
		// Implement any required code.
		ex4.createDriver();
		ex4.commodity();

//		driver.close();
	}
}
