package com.swaglabs.businesscomponents;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.LogStatus;
import com.swaglabs.app.SwagLabs.PG_Common;
import com.swaglabs.utility.Config;
import com.swaglabs.utility.ExtentTest;
import com.swaglabs.utility.GlobalVariable;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LIB_Common extends Config {

	public static void bc_Login(String Username,String Password){
		try {
			System.out.println("Start of bc_Login");
			PG_Common.ele_Username.sendKeys(Username);
			PG_Common.ele_password.sendKeys(Password);
			PG_Common.btn_login.click();
			System.out.println("End of bc_Login");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void bc_OpenBrowser() {
		try {
			System.out.println("Start of bc_OpenBrowser");
			String Browser=Config.getValue("Browser");
			String AppURL=Config.getValue("ApplicationURL");
			if(Browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				Config.driver = new ChromeDriver();
			}else if(Browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				Config.driver = new EdgeDriver();
				System.out.println("MS Edge browser selected");
			}else if(Browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				Config.driver = new FirefoxDriver();
				System.out.println("Firfox browser selected");
			}
			Config.getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			Config.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Config.getDriver().manage().deleteAllCookies();
			Config.driver.get(AppURL);
			if(Config.getDriver().getCurrentUrl().equals(AppURL)) {
				System.out.println("Navigated to the specified URL");
			}
			Config.getDriver().manage().window().maximize() ;
			System.out.println("End of bc_OpenBrowser");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void bc_DriverClose() {
		try {
			System.out.println("Start of bc_DriverClose");
			Config.getDriver().quit();
//			Config.getDriver().close();
			System.out.println("End of bc_DriverClose");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
