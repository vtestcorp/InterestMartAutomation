package com.qa.interestsmart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static Workbook book;
	private static Sheet sheet;
	private static String TEST_DATA_SHEET_PATH = "./src/main/java/com/qa/hubspot/testdata/InterestSmart.xlsx";

	public static Object[][] getTestData(String sheetName) {

		Object data[][] = null;

		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}
	public static String ReadCellData(int vRow, int vColumn,String sheetName) {
		String value = null; // variable for storing the cell value
		Workbook wb = null; // initialize Workbook null
		try {
			// reading data from a file in the form of bytes
			FileInputStream fis = new FileInputStream("TestData\\InterestSmart.xlsx");
			// constructs an XSSFWorkbook object, by buffering the whole stream
			// into the memory
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName); // getting the XSSFSheet object at
												// given
		// index
		Row row = sheet.getRow(vRow); // returns the logical row
		Cell cell = row.getCell(vColumn); // getting the cell representing the
											// given column
		value = cell.getStringCellValue(); // getting cell value
		
		return value; // returns the cell value
	}

	
	public static void main(String[]ar)
	{
		System.out.println(ExcelUtil.ReadCellData(1, 1, "Sheet1"));
	}
	
}
