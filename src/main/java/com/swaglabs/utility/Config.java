package com.swaglabs.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.swaglabs.businesscomponents.LIB_Common;

public class Config extends GlobalVariable  {
public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		Config.driver=driver;
	}
	
	public static String getValue(String Key) throws IOException {
		
		String configFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
		FileInputStream propsInput = new FileInputStream(configFilePath);
		Properties prop = new Properties();
		prop.load(propsInput);
		String Value=prop.getProperty(Key);
		return Value;
	}

}
