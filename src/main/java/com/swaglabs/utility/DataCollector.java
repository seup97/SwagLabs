package com.swaglabs.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataCollector {

	@DataProvider(name="tc_002")
	public Object[][] getDataFromDataprovider() throws IOException{
	   Object[][] S_002 = null;
		String path=Config.getValue("TS_001.ExcelPath");
		//Path of the excel file
		FileInputStream fs = new FileInputStream(path);
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("tc_001");
		//Find number of rows in excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		S_002 = new Object[rowCount][5];
		for (int i = 0; i < rowCount; i++) {
			//Loop over all the rows
			Row row = sheet.getRow(i+1);
			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print excel data in console
				S_002[i][j] = row.getCell(j).toString();
			}
		}
		System.out.println("");
		return S_002;    
	}
	
	@DataProvider (name = "S_001")
	public Object [] [] S_001 () throws IOException
	{		
		Object[][] S_001 =  new Object [2] [2];
		String path=Config.getValue("TS_001.ExcelPath");
		//Path of the excel file
		FileInputStream fs = new FileInputStream(path);
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("tc_001");
		//Find number of rows in excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		S_001 = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			//Loop over all the rows
			Row row = sheet.getRow(i+1);
			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print excel data in console
				S_001[i][j] = row.getCell(j).toString();
			}
		}
		System.out.println("");
		return S_001; 
	}
	
	@DataProvider (name = "S_002")
	public Object [] [] S_002 () throws IOException
	{		
		Object[][] S_002 =  new Object [2] [2];
		String path=Config.getValue("TS_001.ExcelPath");
		//Path of the excel file
		FileInputStream fs = new FileInputStream(path);
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("tc_001");
		//Find number of rows in excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		S_002 = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			//Loop over all the rows
			Row row = sheet.getRow(i+1);
			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print excel data in console
				S_002[i][j] = row.getCell(j).toString();
			}
		}
		System.out.println("");
		return S_002; 
	}

}
