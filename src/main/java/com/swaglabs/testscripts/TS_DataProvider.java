package com.swaglabs.testscripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.swaglabs.businesscomponents.LIB_Common;
import com.swaglabs.businesscomponents.LIB_Home;
import com.swaglabs.utility.Config;
import com.swaglabs.utility.DataCollector;

public class TS_DataProvider extends DataCollector  {
	
//	@Test (dataProvider = "S_001")  
//	public void tc_001 (String username, String password) throws Exception 
//	{
//	  LIB_Common.bc_OpenBrowser();
//	  LIB_Home.bc_waitForPageLoad("High");
//	  LIB_Common.bc_Login(username,password);
//	  LIB_Home.bc_waitForPageLoad("High");
//	  LIB_Common.bc_DriverClose();
//	}

	@Test (dataProvider = "S_002")  
	public void tc_002 (String username, String password) throws Exception 
	{
	  LIB_Common.bc_OpenBrowser();
	  LIB_Home.bc_waitForPageLoad("High");
	  LIB_Common.bc_Login(username,password);
	  LIB_Home.bc_waitForPageLoad("High");
	  LIB_Home.bc_ClickOnCartIcon();
	  Config.getDriver().close();
	}
	

}
