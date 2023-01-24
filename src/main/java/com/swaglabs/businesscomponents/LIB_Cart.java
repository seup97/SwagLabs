package com.swaglabs.businesscomponents;

import static org.testng.Assert.fail;

import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;
import com.swaglabs.app.SwagLabs.PG_Checkout;
import com.swaglabs.app.SwagLabs.PG_Home;
import com.swaglabs.app.SwagLabs.PG_YourCart;
import com.swaglabs.utility.Config;

public class LIB_Cart extends Config{

	public static void bc_ValidateCartItem(){
		try {
			boolean var_Availability;
			String var_ProductPrice;
			String ProductDescription;
			System.out.println("Start of bc_ValidateCartItem"); 
			var_Availability=Config.getDriver().findElement(By.xpath("//div[text()='"+ var_product +"']")).isDisplayed();
			if(var_Availability) {
					System.out.println(var_product+" is verified");
			}else {
				fail("Product Name : " + var_product + " is Not Found");
			}
			var_ProductPrice=PG_YourCart.CartItemPrice.getText();
			ProductDescription=PG_YourCart.CartItemDescription.getText();
			var_price=var_ProductPrice;
			var_description=ProductDescription;
			System.out.println("End of bc_ValidateCartItem");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void bc_ClickOnCheckoutButton(){
		try {
			boolean btnAvailable;
			System.out.println("Start of bc_ClickOnCheckoutButton");
			btnAvailable=PG_YourCart.CheckoutButton.isEnabled();
			if(btnAvailable) {
				PG_YourCart.CheckoutButton.click();
				System.out.println("Checkout button is clicked");
			}else {
				fail("Checkout button is not enabled");
			}
			System.out.println("End of bc_ClickOnCheckoutButton");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void bc_FillCheckoutInformation(String prm_Information) {
		try {
			String data[]=prm_Information.split(",");
			String arr[]= {"firstName","lastName","postalCode"};
			System.out.println("Start of bc_FillCheckoutInformation");
			for(int i=0;i<data.length;i++) {
				Config.getDriver().findElement(By.xpath("//input[@name='"+arr[i]+"']")).sendKeys(data[i]);
				System.out.println(arr[i] + " typed | Value : "+data[i]);
			}
			PG_YourCart.ContinueButton.click();
			System.out.println("End of bc_FillCheckoutInformation");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void bc_ValidateCheckoutItem(String prm_LabelNames) {
		try {
			boolean var_ProdAvailability;
			boolean var_DescriptAvailability;
			boolean var_PriceAvailability;
			String CartInfo;
//			String arr[]= {"Payment Information:","Shipping Information:"};
			String arr[]=prm_LabelNames.split(",");
			System.out.println("Start of bc_ValidateCheckoutItem");
			var_ProdAvailability=Config.getDriver().findElement(By.xpath("//div[text()='"+var_product+"']")).isDisplayed();
			if(var_ProdAvailability) {
				System.out.println("Cart item is Verified | "+var_product);
			}else {
				fail(var_product + " is Not Verified");
			}
			var_DescriptAvailability=Config.getDriver().findElement(By.xpath("//div[text()='"+var_description+"']")).isDisplayed();
			if(var_DescriptAvailability) {
				System.out.println("Product Description is Verified | Description : "+var_description);
			}else {
				fail(var_description + " is Not Found");
			}
			for(int i=0;i<arr.length;i++) {
				CartInfo = Config.getDriver().findElement(By.xpath("//div[text()='"+arr[i]+"']/following-sibling::div[1]")).getText();
				System.out.println(arr[i] +" | "+ CartInfo);
			}
			String var_ItemTotal=PG_YourCart.ItemTotal.getText();
			String arr1[]=var_ItemTotal.split(":");
			String Tx=arr1[1].replaceAll("\\$", "");
			Double a= new Double(Tx);
			if(var_price.equals(arr1[1].trim())) {
				System.out.println("Item Total is Verified | Item Total : "+ arr1[1]);
			}else {
				fail("Item Total is Mismatched | Expected Price: "+ var_price +" Actual Price: "+arr1[1]);
			}
			String var_Tax=PG_YourCart.ItemTax.getText();
			String arr2[]=var_Tax.split(":");
			String Tx1=arr2[1].replaceAll("\\$", "").trim();
			Double b= new Double(Tx1);
			System.out.println("Tax Amount | "+arr2[1].toString());
			String var_TotalAmount=PG_YourCart.TotalAmount.getText();
			String arr3[]=var_TotalAmount.split(":");
			String TAmount=arr3[1].replaceAll("\\$", "").trim();
			Double c= new Double(TAmount);
			Double d=a+b;
			String CalTAmount=d.toString();
			if(TAmount.equals(CalTAmount)) {
				System.out.println("Total Price is Verified | Total Price : "+ "$"+CalTAmount);
			}else {
				fail("Total Price is Mismatched | Expected Price: "+ "$"+TAmount +" Actual Price: "+ "$"+CalTAmount);
			}
			System.out.println("Ends of bc_ValidateCheckoutItem");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public  static void bc_ProductAddToCart() {
		try {
			String var_ProductName;
			System.out.println("Start of bc_ProductAddToCart");
			var_ProductName=PG_Home.ele_FirstProductName.getText();
			PG_Home.ele_FirstProductAddToCartButton.click();
			System.out.println(var_ProductName + " Added to the Cart" );
			System.out.println("End of bc_ProductAddToCart");
			var_product=var_ProductName;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void bc_ClickOnFinishButton() {
		try {
			System.out.println("Start of bc_ClickOnFinishButton");
			PG_YourCart.BtnFinish.click();
			System.out.println("End of bc_ClickOnFinishButton");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void bc_VerifyPlaceOrderMessage() {
		try {
			System.out.println("Start of bc_ClickOnFinishButton");
			boolean HeaderAvailable=PG_Checkout.ele_CheckoutPageHeader.isDisplayed();
			if(HeaderAvailable) {
				System.out.println("Checkout Page is Veriied");
			}else {
				fail("Checkout page is not found");
			}
			boolean MessageAvailable=PG_Checkout.ele_SuccessMessage.isDisplayed();
			if(MessageAvailable) {
				System.out.println("Success Message is verified");
			}else {
				fail("Success Message is not available");
			}
			System.out.println("Start of bc_ClickOnFinishButton");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
