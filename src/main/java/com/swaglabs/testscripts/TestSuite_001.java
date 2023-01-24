package com.swaglabs.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.swaglabs.businesscomponents.LIB_Cart;
import com.swaglabs.businesscomponents.LIB_Common;
import com.swaglabs.businesscomponents.LIB_Home;

public class TestSuite_001{

	@Test(priority = 0)
	public static void tc_001() {
		try {
			System.out.println("Start of tc_001");
			LIB_Common.bc_OpenBrowser();
			LIB_Common.bc_Login("Sehan", "Sehan123");
			LIB_Home.bc_VerifySortingFeature(null, "ASC", "Date");
			System.out.println("End of tc_001");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
