package com.amz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage();
		loginPage=homePage.clickOnSignInLink();
		
		
	}

	@Test(priority=2)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("phone"),prop.getProperty("password"));
	}
	@Test(priority=3)
	public void loginOnlyEmailTest() {
		String errorMsg=loginPage.loginOnlyEmail(prop.getProperty("phone"),"");
		Assert.assertTrue(errorMsg.contains("Enter your password"));
	}
	@Test(priority=4)
	public void loginOnlyEmlInvPwdTest() throws InterruptedException {
		String errorMsg=loginPage.loginOnlyEmlInvPwd(prop.getProperty("phone"),"xxxsadsadsad");
		Assert.assertTrue(errorMsg.contains("Your password is incorrect"));
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
