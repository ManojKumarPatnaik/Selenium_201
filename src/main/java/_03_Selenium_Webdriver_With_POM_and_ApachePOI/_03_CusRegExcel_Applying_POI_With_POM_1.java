package _03_Selenium_Webdriver_With_POM_and_ApachePOI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;

public class _03_CusRegExcel_Applying_POI_With_POM_1 { // Do not change the class name

	// Use this declaration to store values parsed from excel
	public static String[] customerData = new String[5];

	public static String[] readExcelData(String fileName) { // Do not change the method signature

		// Implement code to read data from excel file. Store the values in
		// 'customerData' array. Return the array. */
		String filePath = System.getProperty("user.dir") + File.separator + fileName;
		String sheetName = "customervalid";

		Integer lastRow = null;
		short lastCol = 0;
		FileInputStream file = null;
		try {
			file = new FileInputStream(filePath);

			XSSFWorkbook workbook = null;

			workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheet(sheetName);

			XSSFRow row;
			XSSFCell cell;
			lastRow = sheet.getPhysicalNumberOfRows();
			lastCol = sheet.getRow(0).getLastCellNum();

			for (int r = 0; r < lastRow; r++) {
				row = (XSSFRow) sheet.getRow(r);
				if (row != null) {
					for (int c = 0; c < lastCol; c++) {
						cell = row.getCell(c);
						if (cell == null) {
							customerData[c] = "";
						} else {
							customerData[c] = new DataFormatter().formatCellValue(cell);
						}
					}
				}
			}

			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerData;
	}
}
