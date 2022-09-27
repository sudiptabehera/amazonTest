package com.amz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory -OR:
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	WebElement ContBtn;
	
	@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	WebElement SignInBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement LogoChk;
	//Initializing page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
//	
//	public boolean validateCRMImage() {
//		return LogoChk.isDisplayed();
//	}

	
	public HomePage login(String email, String password) {
		this.email.sendKeys(email);
		ContBtn.click();
		this.password.sendKeys(password);
		SignInBtn.click();
		
		return new HomePage();
		
	}
	public String loginOnlyEmail(String email, String password) {
		this.email.sendKeys(email);
		ContBtn.click();
		this.password.sendKeys(password);
		SignInBtn.click();
		String errorMsg=driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div")).getAttribute("innerHTML");
		return errorMsg;
	}

	public String loginOnlyEmlInvPwd(String email, String password) throws InterruptedException {
		this.email.sendKeys(email);
		ContBtn.click();
		this.password.sendKeys(password);
		SignInBtn.click();
		Thread.sleep(1500);
		String errorMsg=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getAttribute("innerHTML");
		return errorMsg;
	}
}
