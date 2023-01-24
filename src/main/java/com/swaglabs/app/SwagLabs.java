package com.swaglabs.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.swaglabs.utility.Config;

public class SwagLabs extends Config {

	public static class PG_Common extends SwagLabs  {

		public static WebElement ele_Username=Config.getDriver().findElement(By.xpath("//input[@id='user-name']"));

		public static WebElement ele_password = Config.getDriver().findElement(By.xpath("//input[@id='password']"));

		public static WebElement btn_login = Config.getDriver().findElement(By.xpath("//input[@id='login-button']"));

	}

	public static class PG_Home extends SwagLabs{

		public static WebElement ele_ProductPageHeader= Config.getDriver().findElement(By.xpath("//span[@class='title' and text()='Products']"));

		public static WebElement ele_FirstProductName= Config.getDriver().findElement(By.xpath("(//div[@class='inventory_item_label']/descendant::div)[1]"));

		public static WebElement ele_FirstProductAddToCartButton = Config.getDriver().findElement(By.xpath("(//div[@class='inventory_item']/descendant::button[text()='Add to cart'])[1]"));

		public static WebElement ele_CartIcon=Config.getDriver().findElement(By.xpath("//div[@class='shopping_cart_container']"));

		public static WebElement Btn_logout = Config.getDriver().findElement(By.xpath("//a[text()='Logout']"));

	} 
	
	public static class PG_Checkout extends SwagLabs {
		
		public static WebElement ele_CheckoutPageHeader= Config.getDriver().findElement(By.xpath("//span[contains(text(),'Checkout')]"));

		public static WebElement ele_SuccessMessage= Config.getDriver().findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));
		
	}
	
	public static class PG_YourCart extends SwagLabs {
		
		public static WebElement CartPageHeader= Config.getDriver().findElement(By.xpath("//span[@class='title' and text()='Your Cart']"));
		
		public static WebElement CheckoutButton =Config.getDriver().findElement(By.xpath("//button[@id='checkout']"));
		
		public static WebElement ContinueButton= Config.getDriver().findElement(By.xpath("//input[@id='continue']"));
		
		public static WebElement CartItemDescription= Config.getDriver().findElement(By.xpath("(//div[@class='cart_item_label']/descendant::div[@class='inventory_item_desc'])[1]"));
		
		public static WebElement CartItemPrice= Config.getDriver().findElement(By.xpath("(//div[@class='cart_item_label']/descendant::div[@class='inventory_item_price'])[1]"));
		
		public static WebElement ItemTotal= Config.getDriver().findElement(By.xpath("//div[@class='summary_subtotal_label']"));
		
		public static WebElement ItemTax= Config.getDriver().findElement(By.xpath("//div[@class='summary_tax_label']"));
		
		public static WebElement TotalAmount= Config.getDriver().findElement(By.xpath("//div[@class='summary_total_label']"));
		
		public static WebElement BtnFinish= Config.getDriver().findElement(By.xpath("//button[@id='finish']"));
	}

}
