package _03_Selenium_Webdriver_With_POM_and_ApachePOI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class _04_CargoShipping_Applying_POI_With_POM_2
{

	public static void writeExcelData(String fileName, String result) throws Exception { // Do not change the method
																							// signature
		// Write the Test result to the excel sheet

		FileInputStream inFile = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(inFile);
		XSSFSheet sheet = workbook.getSheet("TestCase");

		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(result);

		FileOutputStream outFile = new FileOutputStream(fileName);

		workbook.write(outFile);
		outFile.close();
		workbook.close();
	}
}
