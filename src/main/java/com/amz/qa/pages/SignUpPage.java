package com.amz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class SignUpPage extends TestBase {

	@FindBy(xpath="//*[@id=\"ap_customer_name\"]")
	WebElement customerName;
	
	@FindBy(xpath="//*[@id=\"auth-country-picker-container\"]/span/span")
	WebElement mobileCountryDrop;
	
	@FindBy(xpath="//*[@id=\"ap_phone_number\"]")
	WebElement mobileTextBox;
	
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement emailTextBox;
	
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	WebElement passwordTextBox;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	

	public String verifyTitleSignUp() {
		
		return driver.getTitle();
	}
	
	public String SignUpVerify(String name, String country, String phone, String email, String password) {
		customerName.sendKeys(name);
		mobileCountryDrop.click();
		driver.findElement(By.xpath("//a[contains(text(),'"+country+"')]")).click();
		mobileTextBox.sendKeys(phone);
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(password);
		return driver.findElement(By.xpath("//*[@id=\"auth-phoneNumber-missing-alert\"]/div/div")).getAttribute("innerHTML");
		
	}

}
