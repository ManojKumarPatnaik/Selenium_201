package _03_Selenium_Webdriver_With_POM_and_ApachePOI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class _02_CusRegExcel_Applying_POI_2 { // DO NOT change the class name

	// Wrire the below values into excel sheet. DO NOT change the values
	static String[] fields1 = new String[] { "Tester", "32", "XYZ", "2323245235", "test1@gmail.com" };
	static String[] fields2 = new String[] { "Tester1", "33", "ABC", "4323245125", "test2@gmail.com" };
	static String[] fields3 = new String[] { "Tester2", "34", "KLM", "1323245235", "test3@gmail.com" };
	static String filePath;

	public static String getExcelPath(String sheetName) {
		// Implement code to locate the excel file. Return the filepath
		filePath = System.getProperty("user.dir") + "\\CustReg.xlsx";
		return filePath;
	}

	public static void writeExcelData(String sheetName) throws IOException { // DO NOT change the method signature
		// Implement code to write the given fields1,fields2,fields3 data to excel
		// sheet.
		// Write from third zero(without any headers)
		System.out.println(filePath);
		FileInputStream inFile = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inFile);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getPhysicalNumberOfRows();

		String result[][] = { fields1, fields2, fields3 };

		System.out.println(lastRow);

		for (int r = 0; r < result.length; r++) {
			Row row = sheet.createRow(r + lastRow);
			for (int c = 0; c < result[0].length; c++) {
				Cell cell = row.createCell(c);
				cell.setCellType(cell.CELL_TYPE_STRING);
				cell.setCellValue(result[r][c]);
			}
		}
		FileOutputStream outFile = new FileOutputStream(filePath);

		workbook.write(outFile);
		outFile.close();
		workbook.close();
	}

	public static void main(String[] args) throws Exception {
		// Add required code
		getExcelPath("customervalid");
		writeExcelData("customervalid");
	}
}
