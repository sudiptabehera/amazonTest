package com.amz.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;
public class ProductPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"buy-now-button\"]")
	WebElement buyNowBtn;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public DeliveryPayment buynow()  {
		
		buyNowBtn.click();
		
		return new DeliveryPayment();
		
	}
	
	
}
