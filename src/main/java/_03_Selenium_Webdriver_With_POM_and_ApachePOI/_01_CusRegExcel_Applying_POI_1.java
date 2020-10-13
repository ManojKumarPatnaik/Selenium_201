package _03_Selenium_Webdriver_With_POM_and_ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class _01_CusRegExcel_Applying_POI_1 { // Do NOT change the class name
	static String filePath;

	public static Object[][] readExcelData(String sheetName) throws IOException { // DO NOT change the method signature
		// Implement code to read data from excel sheet in a 2-D array. Return the array
		Integer lastRow = null;
		short lastCol = 0;
		Object[][] sheetData = null;
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		XSSFRow row;
		XSSFCell cell;
		lastRow = sheet.getPhysicalNumberOfRows();
		lastCol = sheet.getRow(1).getLastCellNum();

		sheetData = new Object[lastRow][lastCol];
		System.out.println(sheet.getPhysicalNumberOfRows());

		for (int r = 0; r < lastRow; r++) {
			row = (XSSFRow) sheet.getRow(r);
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

	public static String getExcelPath(String sheetName) {
		// Implement code to locate the excel file. Return the filepath
		filePath = System.getProperty("user.dir") + "/CustReg.xlsx";
		return filePath;
	}

	public static void main(String[] args) throws Exception {
		// Add required code
		getExcelPath("customervalid");
		readExcelData("customervalid");
		System.out.println(Arrays.deepToString(readExcelData("customervalid")));
	}
}
