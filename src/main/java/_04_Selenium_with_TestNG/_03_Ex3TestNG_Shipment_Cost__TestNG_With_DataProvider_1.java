package _04_Selenium_with_TestNG;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class _03_Ex3TestNG_Shipment_Cost__TestNG_With_DataProvider_1
{
	public static WebDriver driver;

	@BeforeSuite
	public void createDriver() { // DO NOT change the method signature
		// Create driver and assign it to 'static' driver variable
		driver = _03_DriverSetup_Shipment_Cost__TestNG_With_DataProvider_1.getWebDriver();
	}

	@DataProvider(name = "shipmentData")
	public Object[][] shipmentData() throws IOException {
		// Parse data from Shipmentdetails.xlsx and return the 2-dimensional array
		String inputFile = System.getProperty("user.dir") + File.separator + "ShipmentDetails.xlsx";

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

	// DO NOT change the method signature
	@Test(dataProvider = "shipmentData")
	void testShipment(String orginPort, String destinationPort, String railModeCharge, String roadModeCharge,
			String airModeCharge) throws InterruptedException {
		// Select the souce/destination as specified in description.
		// Test the tabled data against the excel data as specified in description.

		Select src = new Select(driver.findElement(By.name("origin_id")));
		src.selectByVisibleText(orginPort);

		Select dest = new Select(driver.findElement(By.name("destination_id")));
		dest.selectByVisibleText(destinationPort);

		driver.findElement(By.name("submit")).submit();

		Thread.sleep(1000);
		WebElement htmltable = driver.findElement(By.xpath(".//*[@name='charge']/tbody"));
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
		for (int r = 0; r < rows.size(); r++) {
			List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
			for (int c = 1; c < columns.size(); c++) {
				if (columns.get(0).getText().equals("Rail")) {
					Assert.assertEquals("The Rail mode Charge doesnt match", Float.parseFloat(railModeCharge),
							Float.parseFloat(columns.get(c).getText()));
				} else if (columns.get(0).getText().equals("Road")) {
					Assert.assertEquals("The Road mode Charge doesnt match", Float.parseFloat(roadModeCharge),
							Float.parseFloat(columns.get(c).getText()));
				} else if (columns.get(0).getText().equals("Air")) {
					Assert.assertEquals("The Air mode Charge doesnt match", Float.parseFloat(airModeCharge),
							Float.parseFloat(columns.get(c).getText()));
				}
			}
		}
	}

	public void shipment() throws IOException, InterruptedException {
		// Invoke the test using TestNG ONLY HERE.
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { _03_Ex3TestNG_Shipment_Cost__TestNG_With_DataProvider_1.class });
		testSuite.run();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		_03_Ex3TestNG_Shipment_Cost__TestNG_With_DataProvider_1 ex3 = new _03_Ex3TestNG_Shipment_Cost__TestNG_With_DataProvider_1();
		// Implement any required code.
		ex3.createDriver();
		ex3.shipment();

		driver.close();
	}
}
