package com.amz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class DeliveryPayment extends TestBase{
	
	@FindBy(xpath="(//*[@type=\"radio\"])[6]")
	WebElement upiRadio;
	
	@FindBy(xpath="(//*[@placeholder=\"Ex: MobileNumber@upi\"])")
	WebElement upiTextBtn;
	
	@FindBy(xpath="//*[@name=\"ppw-widgetEvent:ValidateUpiIdEvent\"]")
	WebElement upiVerifyBtn;
	
	@FindBy(xpath="(//*[@name=\"ppw-widgetEvent:SetPaymentPlanSelectContinueEvent\"])[3]")
	WebElement continueBtn;
	
	public DeliveryPayment() {
		PageFactory.initElements(driver, this);
	}
	public PlaceOrderPage placeOrder() throws InterruptedException {
		upiRadio.click();
		upiTextBtn.sendKeys("9114110151@ybl");
		upiVerifyBtn.click();
		Thread.sleep(4000);
		continueBtn.click();
		return new PlaceOrderPage();
	}
	
}
