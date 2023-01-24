package com.swaglabs.testscripts;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.swaglabs.businesscomponents.LIB_Common;
import com.swaglabs.schema.S_001;
import com.swaglabs.utility.DataCollector;

public class TS_001{
	
	private ThreadLocal<String> testName = new ThreadLocal<String>();

	//	public static void tc_001(S_001 s_001) {
	//		try {
	//			System.out.println("Starts of tc_001");
	//			LIB_Common.bc_OpenBrowser();
	//			LIB_Common.bc_Login(s_001.prm_Username, s_001.prm_Password);
	//			System.out.println("End of tc_001");
	//		}catch(Exception e) {
	//			System.out.println(e);
	//		}
	//	}
	//	public static void tc_001_main() throws IOException {
	//		
	//		S_001 s_001= new S_001();
	//		tc_001(s_001);
	//	}

	@Test(dataProvider="tc_002")
	public static void tc_002(Object [][] S_002) {
		try {
			System.out.println("Starts of tc_001");
			LIB_Common.bc_OpenBrowser();
			LIB_Common.bc_Login(S_002[0][0].toString(),S_002[0][0].toString());
			System.out.println("End of tc_001");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
//	@BeforeMethod
//	   public void BeforeMethod(Method method, Object[] testData){
//	       testName.set(method.getName() + "_" + testData[0]);
//	   }
//
//	@Override
//	   public String getTestName() {
//	       return testName.get();
//	   }
}
