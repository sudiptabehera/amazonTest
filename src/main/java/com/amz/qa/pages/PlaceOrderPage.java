package com.amz.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;
public class PlaceOrderPage extends TestBase{
	
	@FindBy(xpath="//td[@class=\"a-color-price a-size-medium a-text-right grand-total-price aok-nowrap a-text-bold a-nowrap\"]")
	WebElement price;
	
	
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	public String price() {

		return price.getAttribute("innerHTML");
	}
	
	
	
}
