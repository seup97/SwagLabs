package com.swaglabs.utility;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentTest {
	public static com.relevantcodes.extentreports.ExtentTest test12;
	static ExtentReports report;
	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\resources\\Reports\\Extend.html");
		 test12= report.startTest("ExtentDemo");
	}
	@Test
	public void extentReportsDemo()
	{
		WebDriverManager.chromedriver().setup();	 
		Config.driver = new ChromeDriver();
		Config.getDriver().get("https://www.google.co.in");
		if(Config.getDriver().getTitle().equals("Google"))
		{
			test12.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else
		{
			test12.log(LogStatus.FAIL, "Test Failed");
		}
	}
	@AfterClass
	public static void endReport()
	{
		report.endTest(test12);
		report.flush();
	}

}
