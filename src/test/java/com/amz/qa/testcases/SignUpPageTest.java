package com.amz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.ContactsPage;
import com.amz.qa.pages.ProductPage;
import com.amz.qa.pages.SignUpPage;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;
import com.amz.qa.pages.DeliveryPayment;
import com.amz.qa.util.TestUtil;

public class SignUpPageTest extends TestBase{
	
	HomePage homePage;
	SignUpPage signUpPage;
	TestUtil testUtil;
	
	public SignUpPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		homePage=new HomePage();
		signUpPage=homePage.clickOnSignUpLink(); 
		
	}
	
	@Test(priority=1)
	public void titleSignUpTest() {
		String title=signUpPage.verifyTitleSignUp();
		Assert.assertEquals(title, "Amazon Registration");
	}
	
	
	
	@Test(priority=8)
	public void signUpTest1() {
		String errorMsg=signUpPage.SignUpVerify("Sudipta Behera","+1", "","" ,"Saskdkjjiadkj");
		Assert.assertTrue(errorMsg.contains("Enter your mobile number"));
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

