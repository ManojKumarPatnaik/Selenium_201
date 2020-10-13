package _03_Selenium_Webdriver_With_POM_and_ApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.poi.ss.usermodel.*;

public class CC_CargoShipping
{
	// Location of the excel file
	public static String filePath = null;

	public static void getExcelPath(String firstSheetName) {
		// get the file path of the excel sheet
		filePath = System.getProperty("user.dir") + File.separator + "cargo.xlsx";
	}

	public static Object[][] readExcelData(String firstSheetName) throws Exception {
		// read the data from excel sheet and store it in 2-D array. Return the array
		Integer lastRow = null;
		short lastCol = 0;
		Object[][] sheetData = null;
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(firstSheetName);

		XSSFRow row;
		XSSFCell cell;
		lastRow = sheet.getPhysicalNumberOfRows();
		lastCol = sheet.getRow(0).getLastCellNum();

		sheetData = new Object[lastRow][lastCol];
//		System.out.println(sheet.getPhysicalNumberOfRows());

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

	public static void writeExcelData(String firstSheetName, String displayMsg, String testCaseResult, int row)
			throws Exception {
		// Write the display message and test result in the new sheet 'customervalid1'

		FileInputStream inFile = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inFile);
		XSSFSheet sheet = workbook.getSheet(firstSheetName);
		if (workbook.getSheetIndex(firstSheetName) == -1) {
			sheet = workbook.createSheet(firstSheetName);
		}

		Row r = sheet.createRow(row);
		Cell cell = r.createCell(0);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(displayMsg);

		Cell cell1 = r.createCell(1);
		cell1.setCellType(cell1.CELL_TYPE_STRING);
		cell1.setCellValue(testCaseResult);

		FileOutputStream outFile = new FileOutputStream(filePath);

		workbook.write(outFile);
		outFile.close();
		workbook.close();
	}
}
