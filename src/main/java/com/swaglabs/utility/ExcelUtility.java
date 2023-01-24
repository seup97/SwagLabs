package com.swaglabs.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility extends Config {

	
	
	 public static HashMap<String, String> Readexcel(String sheetName,String ExcelPath) {
		try {			
			System.out.println("Start of bc_ReadExcel");
			String path=Config.getValue(ExcelPath);
			//Path of the excel file
			FileInputStream fs = new FileInputStream(path);
			//Creating a workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int colCount = row.getLastCellNum();
			int rowCount = sheet.getLastRowNum();
			for (int i = 0; i < colCount; i++) {
				//print cloumn names
				String colValue=sheet.getRow(0).getCell(i).toString();
				System.out.println("Column Name: "+colValue);
				//Create a loop to print cell values in a row
				String RowValue=sheet.getRow(rowCount).getCell(i).toString();
				System.out.print("Value: "+RowValue);
				ExcelVal.put(colValue, RowValue);
				System.out.println();
			}
			//		System.out.println(ExcelVal.get("Name"));
			System.out.println("Ends of bc_ReadExcel");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ExcelVal;
	}


	//	private static XSSFSheet ExcelWSheet;
	//
	//	private static XSSFWorkbook ExcelWBook;
	//
	//	private static XSSFCell Cell;
	//
	//	private static XSSFRow Row;
	//
	//public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
	//
	//   String[][] tabArray = null;
	//
	//   try {
	//
	//	   FileInputStream ExcelFile = new FileInputStream(FilePath);
	//
	//	   // Access the required test data sheet
	//
	//	   ExcelWBook = new XSSFWorkbook(ExcelFile);
	//
	//	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
	//
	//	   int startRow = 1;
	//
	//	   int startCol = 1;
	//
	//	   int ci,cj;
	//
	//	   int totalRows = ExcelWSheet.getLastRowNum();
	//
	//	   // you can write a function as well to get Column count
	//
	//	   int totalCols = 2;
	//
	//	   tabArray=new String[totalRows][totalCols];
	//
	//	   ci=0;
	//
	//	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   
	//
	//		  cj=0;
	//
	//		   for (int j=startCol;j<=totalCols;j++, cj++){
	//
	//			   tabArray[ci][cj]=getCellData(i,j);
	//
	//			   System.out.println(tabArray[ci][cj]);  
	//
	//				}
	//
	//			}
	//
	//		}
	//
	//	catch (FileNotFoundException e){
	//
	//		System.out.println("Could not read the Excel sheet");
	//
	//		e.printStackTrace();
	//
	//		}
	//
	//	catch (IOException e){
	//
	//		System.out.println("Could not read the Excel sheet");
	//
	//		e.printStackTrace();
	//
	//		}
	//
	//	return(tabArray);
	//
	//	}
	//
	//public static String getCellData(int RowNum, int ColNum) throws Exception {
	//
	//	try{
	//
	//		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	//
	//		int dataType = Cell.getCellType();
	//
	//		if  (dataTypes == 3) {
	//
	//			return "";
	//
	//		}else{
	//
	//			String CellData = Cell.getStringCellValue();
	//
	//			return CellData;
	//
	//		}catch (Exception e){
	//
	//		System.out.println(e.getMessage());
	//
	//		throw (e);
	//
	//		}
	//
	//	}
	//
	//}
	//
	//
	//public static void ExcelPath(String File, String SheetName) {
	//	try {
	//		projectPath=System.getProperty("user.dir");
	//		workbook= new XSSFWorkbook(projectPath + "/Data/"+File);
	//		sheet=workbook.getSheet(SheetName);
	//	}catch(Exception e) {
	//		e.printStackTrace();
	//	}
	//}
	//public static void getRowCount() {
	//	try {
	//		sheet.getLastRowNum();
	//		int rowCount=sheet.getPhysicalNumberOfRows();
	//		System.out.println("No of row count : " + rowCount);
	//	}catch(Exception e) {
	//		e.printStackTrace();
	//	}
	//}
	//public static void getCellData(int row,int column) {
	//	try {
	//		String cellData=sheet.getRow(row).getCell(column).getStringCellValue();
	//		System.out.println("Row : " +row + " Column : " + column + "Data : "+cellData);
	//	}catch(Exception e) {
	//		e.printStackTrace();
	//	}
	//}
	//public static void getCellDataNumeric() {
	//	try {
	//		double cellData=sheet.getRow(0).getCell(0).getNumericCellValue();
	//		System.out.println("Data : " +cellData);
	//	}catch(Exception e) {
	//		e.printStackTrace();
	//	}
	//}
}

