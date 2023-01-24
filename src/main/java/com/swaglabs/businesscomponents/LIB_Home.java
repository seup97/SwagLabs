package com.swaglabs.businesscomponents;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.swaglabs.app.SwagLabs.PG_Home;
import com.swaglabs.app.SwagLabs.PG_YourCart;
import com.swaglabs.utility.Config;
import com.testautomationguru.utility.PDFUtil;


public class  LIB_Home extends Config{


	public static void bc_VerifyProductPage(){
		try {
			boolean var_Availability;
			System.out.println("Start of bc_VerifyProductPage");
			var_Availability=PG_Home.ele_ProductPageHeader.isDisplayed();
			if(var_Availability) {
				System.out.println("Product page is verified");
			}else {
				fail("Product page is not verified");
			}
			System.out.println("End of bc_VerifyProductPage");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}		

	public static void  bc_ClickOnCartIcon() {
		try {
			boolean Availability;
			System.out.println("Start of bc_ClickOnCartIcon");			
			PG_Home.ele_CartIcon.click();
			Availability=PG_YourCart.CartPageHeader.isDisplayed();
			if(Availability) {
				System.out.println("Naviagted to the Cart Page");
			}else {
				fail("Cannot fount Cart Page");
			}
			System.out.println("End of bc_ClickOnCartIcon");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void  bc_VerifyGenerateDate() {
		try {
			System.out.println("Start of bc_VerifyGenerateDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Month now = LocalDate.now().getMonth();
			String ad=now.toString();
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(ad));
			int monthInt1 = cal.get(Calendar.MONTH) + 1;
			int year=LocalDate.now().getYear();
			LocalDate TDate = LocalDate.now();
			String asd = TDate.toString();
			SimpleDateFormat sdformat1 = new SimpleDateFormat("yyyy-MM");
			Date d1 = sdformat1.parse(asd);
			String testDate = sdformat1.format(d1).toString();
			System.out.println("End of bc_VerifyGenerateDate");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void ReadExcel(String sheetName,String prm_Type){
		try {			
			System.out.println("Start of bc_ReadExcel");
			String path=Config.getValue("TestSuite_001.ExcelPath");
			//Path of the excel file
			FileInputStream fs = new FileInputStream(path);
			//Creating a workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int colCount = row.getLastCellNum();
			int rowCount = sheet.getLastRowNum();
			if(prm_Type.equals("Column")) {
				for (int i = 0; i < colCount; i++) {
					//print cloumn names
					String colValue=sheet.getRow(0).getCell(i).toString();
					System.out.print("Column Name: "+colValue+"=");
					//Create a loop to print cell values in a row
					for (int j = 1; j < rowCount; j++) {
						//Print Excel data in console
						System.out.print("Value: "+sheet.getRow(j).getCell(i));
						String RowValue=sheet.getRow(j).getCell(i).toString();
						ExcelVal.put(colValue, RowValue);
					}
					System.out.println();
				}
			}
			if(prm_Type.equals("Row")) {
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
			}
			System.out.println(ExcelVal.get("Name"));
			System.out.println("Ends of bc_ReadExcel");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void  bc_waitForPageLoad(String prm_WaitTimeKeyword) {
		try {
			System.out.println("Start of bc_waitForPageLoad");
			String ab=Config.getValue("PageLoad");
			String[] ab1=ab.split(",");
			if(prm_WaitTimeKeyword.equals("Low")) {
				String cd=ab1[0];
				int i=Integer.parseInt(cd);
				Thread.sleep(i);
			}
			if(prm_WaitTimeKeyword.equals("Medium")) {
				String cd=ab1[1];
				int i=Integer.parseInt(cd);
				Thread.sleep(i);
			}
			if(prm_WaitTimeKeyword.equals("High")) {
				String cd=ab1[2];
				int i=Integer.parseInt(cd);
				Thread.sleep(i);
			}
			System.out.println("End of bc_waitForPageLoad");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void bc_CheckSort() throws ParseException {
		System.out.println("Start of bc_CheckSort");
		List<String> list1 = new ArrayList<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<String> list4 = new ArrayList<String>();
		list1.add("September 2022");
		list1.add("November 2022");
		for(int i=0;i<list1.size();i++) {
			String st1=list1.get(i).replaceAll("[^A-Za-z]", "");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(st1));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			String st2=list1.get(i).replaceAll("[^0-9]", "");
			Integer yearint=Integer.parseInt(st2);;
			list2.add(monthInt);
			list3.add(yearint);
		}
		for(int n=0;n<list3.size();n++) {
			YearMonth FYearMonth = YearMonth.of(list3.get(n), list2.get(n));
			String d=FYearMonth.toString();
			list4.add(d);
		}
		Collections.sort(list4);  
		for(String dates:list4) {
			System.out.println(list4);
		}
		System.out.println("End of bc_CheckSort");
	}

	public static void bc_VerifyTextFormat() {
		String s = "7 Installement November 2022 (202260): 12/02/2022 - 11/05/2023"; 
		String [] arr=s.split("\\s+");
		SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date sdate=sdfrmt.parse(arr[5].trim());
			Date Edate=sdfrmt.parse(arr[7].trim());
			if(sdate.before(Edate)) {
				String DateFormat="(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}";
				String TermFormat="[a-zA-Z]{3,9}\\s+[0-9]{4}\\s+\\([0-9]{6}+\\)";
				String InstallementFormat="\\d{1}\\s+[a-zA-Z]{12}";
				Pattern pattern = Pattern.compile("^"+InstallementFormat+"\\s+"+TermFormat+"\\:\\s+"+DateFormat+"\\s+\\-\\s+"+DateFormat);
				Matcher matcher = pattern.matcher(s);
				if(matcher.find()) {
					System.out.println("Text Formate is verified " + matcher.group());
				}else {
					System.out.println("Text Format mismatched");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void bc_GenerateDate() {		
		try {
			String var_a="Dec. 02, 2022";
			System.out.println("Start of bc_GenerateDate");
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM. dd, yyyy");
			Date date = sdf.parse(var_a);
			c.setTime(date);
			c.add(Calendar.MONTH, 5);
			String FMonth=sdf.format(c.getTime());
			c.setTime(date);
			c.add(Calendar.DATE, 5);
			String FDate=sdf.format(c.getTime());
			c.setTime(date);
			c.add(Calendar.YEAR, 5);
			String FYear=sdf.format(c.getTime());
			System.out.println("Generated Future Month | "+FMonth);
			System.out.println("Generated Future Date | "+FDate);
			System.out.println("Generated Future Year | "+FYear);
			System.out.println("End of bc_GenerateDate");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void bc_VerifySortingFeature(String prm_HeaderName,String prm_SortingOption,String SortingDataType){
		try {
			Integer var_Headercount=0;
			Integer var_ColumnIndex=0;
			Integer var_Rowcount=0;
			String var_Header = null;
			Boolean var_ValidHeader=false;
			String var_DateValue;
			Double var_NumberValue;
			int RowCount;
			System.out.println("Start of bc_VerifySortingFeature");
			prm_HeaderName="Date";
			String [] arr_HeaderName=prm_HeaderName.split(",");
			int xpathCount = PG_Home.getDriver().findElements(By.xpath("//table/thead//td/span[contains(@class,'text')]")).size();
			for(int i=0;i<arr_HeaderName.length;i++) {
				for(int k=1;k<xpathCount;k++) {                      
					//get a header name using gettext command "xpath=(//table/thead//td/span[contains(@class,'text')])[header_Index]"
					if(var_Header.equals(arr_HeaderName[i])) {
						var_ColumnIndex=i;
						var_ValidHeader=true;
						break;
					}else {
						var_ValidHeader=false;
					}
				}
				if(!var_ValidHeader) {
					fail("Header name cannot find");
				}
				String [] arr_SortOpt=prm_SortingOption.split(",");
				if(SortingDataType.equalsIgnoreCase("Date")) {
					ArrayList<Date> ascDates=new ArrayList<Date>();
					ArrayList<Date> descDates=new ArrayList<Date>();
					ArrayList<Date> ascSortDates=new ArrayList<Date>();
					ArrayList<Date> descSortDates=new ArrayList<Date>();
					SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");
					java.util.Date Date;
					RowCount = PG_Home.getDriver().findElements(By.xpath("//table/thead//td/span[contains(@class,'text')]")).size();
					for(int k=0;k<arr_SortOpt.length;k++) {
						if(arr_SortOpt[k].equalsIgnoreCase("ASC")) {
							//click on header downfilter or upfilter
							for(int m=1;m<=1;m++) {
								var_DateValue="07 Jan 2023";
								String var_DateValue1="07 May 2023";
								try {
									Date=sdf.parse(var_DateValue);
									ascDates.add(Date);
									Date=sdf.parse(var_DateValue1);
									ascDates.add(Date);
								}catch(ParseException e) {
									e.printStackTrace();
								}
							}
							ascSortDates.addAll(ascDates);
							java.util.Collections.sort(ascSortDates);
							if(ascSortDates.equals(ascDates)) {
								System.out.println(arr_HeaderName[i]+" values are sorted in the ascending order");

							}

						}else if(arr_SortOpt[k].equalsIgnoreCase("DES")) {
							//click on header downfilter or upfilter
							for(int m=1;m<RowCount;m++) {
								var_DateValue="07 Jan 2023";
								try {
									Date=sdf.parse(var_DateValue);
									descDates.add(Date);
								}catch(ParseException e) {
									e.printStackTrace();
								}
							}
							descSortDates.addAll(descDates);
							java.util.Collections.sort(descSortDates, java.util.Collections.reverseOrder());
							if(descSortDates.equals(descDates)) {
								System.out.println(arr_HeaderName[i]+" values are sorted in the descending order");
								
							}

						}else {
							fail("Invalid value passed for sorting option");
						}
					}
				}
				else if(SortingDataType.equalsIgnoreCase("Numeric")) {
					ArrayList<Double> ascNumbers=new ArrayList<Double>();
					ArrayList<Double> descNumbers=new ArrayList<Double>();
					ArrayList<Double> ascSortNumbers=new ArrayList<Double>();
					ArrayList<Double> descSortNumbers=new ArrayList<Double>();
					RowCount = PG_Home.getDriver().findElements(By.xpath("//table/thead//td/span[contains(@class,'text')]")).size();
					for(int k=0;k<arr_SortOpt.length;k++) {
						if(arr_SortOpt[k].equalsIgnoreCase("ASC")) {
							//click on header downfilter or upfilter
							for(int m=1;m<RowCount;m++) {
								String Num="$45.00";
								Num=Num.replace("$", "").replace(",", "").trim();
								var_NumberValue=Double.parseDouble(Num);
								ascNumbers.add(var_NumberValue);
							}
							ascSortNumbers.addAll(ascNumbers);
							java.util.Collections.sort(ascSortNumbers);
							if(ascSortNumbers.equals(ascNumbers)) {
								System.out.println(arr_HeaderName[i]+" values are sorted in the ascending order");
							}

						}else if(arr_SortOpt[k].equalsIgnoreCase("DES")) {
							//click on header downfilter or upfilter
							for(int m=1;m<RowCount;m++) {
								String Num="$45.00";
								Num=Num.replace("$", "").replace(",", "").trim();
								var_NumberValue=Double.parseDouble(Num);
								descNumbers.add(var_NumberValue);
							}
							descSortNumbers.addAll(descNumbers);
							java.util.Collections.sort(descSortNumbers);
							if(descSortNumbers.equals(descNumbers)) {
								System.out.println(arr_HeaderName[i]+" values are sorted in the ascending order");
								
							}

						}else {
							fail("Invalid value passed for sorting option");
						}
					}
				}
				
				else if(SortingDataType.equalsIgnoreCase("String")) {
					ArrayList<String> ascCharacters=new ArrayList<String>();
					ArrayList<String> descCharacters=new ArrayList<String>();
					ArrayList<String> ascSortCharacters=new ArrayList<String>();
					ArrayList<String> descSortCharacters=new ArrayList<String>();
					RowCount = PG_Home.getDriver().findElements(By.xpath("//table/thead//td/span[contains(@class,'text')]")).size();
					for(int k=0;k<arr_SortOpt.length;k++) {
						if(arr_SortOpt[k].equalsIgnoreCase("ASC")) {
							//click on header downfilter or upfilter
							for(int m=1;m<RowCount;m++) {
								String Char="Sauce Lab";
								Char=Char.replaceAll("[^A-Za-z]", "");
								ascCharacters.add(Char);
							}
							ascSortCharacters.addAll(ascCharacters);
							java.util.Collections.sort(ascSortCharacters);
							if(ascSortCharacters.equals(ascCharacters)) {
								System.out.println(arr_HeaderName[i]+" values are sorted in the ascending order");
							}

						}else if(arr_SortOpt[k].equalsIgnoreCase("DES")) {
							//click on header downfilter or upfilter
							for(int m=1;m<RowCount;m++) {
								String Char="Sauce Lab";
								//get all string values
								Char=Char.replaceAll("[^A-Za-z]", "");
								descCharacters.add(Char);
							}
							descSortCharacters.addAll(descCharacters);
							java.util.Collections.sort(descSortCharacters);
							if(descSortCharacters.equals(descCharacters)) {
								System.out.println(arr_HeaderName[i]+" values are sorted in the ascending order");
							}

						}else {
							fail("Invalid value passed for sorting option");
						}
					}
				}				
			}
			System.out.println("End of bc_VerifySortingFeature");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GenerateRandomValue() {
		String IntValue=String.valueOf(java.util.concurrent.ThreadLocalRandom.current().nextInt(Integer.valueOf("10"), Integer.valueOf("32")));
		String DoubleValue=String.format("%.2f",java.util.concurrent.ThreadLocalRandom.current().nextDouble(Double.parseDouble("1.50"), Double.parseDouble("5.50")));
	}


}
