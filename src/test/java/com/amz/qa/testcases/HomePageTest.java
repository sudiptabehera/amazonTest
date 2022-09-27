package com.amz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.DeliveryPayment;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;
import com.amz.qa.pages.PlaceOrderPage;
import com.amz.qa.pages.ProductPage;
import com.amz.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	HomePage homePage;
	PlaceOrderPage signUpPage;
	LoginPage loginPage;
	ProductPage productPage;
	DeliveryPayment deliveryPayment;
	PlaceOrderPage placeOrderPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		homePage= new HomePage();
		loginPage= new LoginPage();
		loginPage=homePage.clickOnSignInLink();
		homePage=loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		
//		homePage=loginPage.
		
	}
	
	
	@Test(priority=1)
	public void mobileBasicTest() throws InterruptedException{
//		testUtil.switchToFrame();
		homePage.searchItem("mobile");
		homePage.changeFilter();
		productPage=homePage.selectItem(3);
		testUtil.switchToWindow();
		deliveryPayment=productPage.buynow();
		placeOrderPage=deliveryPayment.placeOrder();
		System.out.println (placeOrderPage.price());
	}
	@Test(priority=2)
	public void yogaMatTest() throws InterruptedException{
//		testUtil.switchToFrame();
		homePage.searchItem("Yoga Mat");
		homePage.changePriceFilter("0","500");
		productPage=homePage.selectItem(5);
		testUtil.switchToWindow();
		deliveryPayment=productPage.buynow();
		placeOrderPage=deliveryPayment.placeOrder();
		System.out.println (placeOrderPage.price());
	}
	


	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}


