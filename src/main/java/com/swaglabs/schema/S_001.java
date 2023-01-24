package com.swaglabs.schema;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.swaglabs.testscripts.test;
import com.swaglabs.utility.Config;
import com.swaglabs.utility.ExcelUtility;

public class S_001 extends ExcelUtility {


	public String prm_Username;
	public String prm_Password;

	public String getPrm_Username() {
		return ExcelVal.get("prm_Username");
	}

	public void setPrm_Username(String prm_Username) {
		this.prm_Username=prm_Username;
	}

	public String getPrm_Password() {
		return ExcelVal.get("prm_Password");
	}

	public void setPrm_Password(String prm_Password) {
		this.prm_Password=prm_Password;
	}

	public void getExcelValue() {
		try {
			String path=Config.getValue("TS_001.ExcelPath");
			Readexcel("tc_001",path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

}
