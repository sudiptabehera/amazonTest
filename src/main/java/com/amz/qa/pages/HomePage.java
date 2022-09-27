package com.amz.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;
public class HomePage extends TestBase{
	@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
	WebElement searchBox;
	
	@FindBy(xpath="//*[@id=\"nav-search-submit-button\"]")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/span/span")
	WebElement accountDropDown;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement accountUserName;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-ya-signin\"]/a")
	WebElement accountSignIn;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-ya-newCust\"]/a")
	WebElement accountSignUp;
	
	
	@FindBy(xpath="//*[@id=\"n/1805559031\"]/span/a")
	WebElement basicFilter ;
	
	@FindBy(xpath="//*[@id=\"high-price\"]")
	WebElement highPriceFilter ;
	
	@FindBy(xpath="//*[@id=\"low-price\"]")
	WebElement lowPriceFilter ;
	
	@FindBy(xpath="(//input[@class=\"a-button-input\"])[8]")
	WebElement goBtnFilter ;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserName() {
		return accountUserName.getAttribute("innerHTML");
	}
	
	public LoginPage clickOnSignInLink() {
		accountDropDown.click();
		return new LoginPage();
	}
	
	public SignUpPage clickOnSignUpLink() {
		Actions action = new Actions(driver);
		action.moveToElement(accountDropDown).perform();
		accountSignUp.click();
		return new SignUpPage();
	}

	public void searchItem(String item) {
		searchBox.sendKeys(item);
		searchButton.click();
	}

	public void changeFilter() {
		basicFilter.click();	
	}
	public void changePriceFilter(String minPrice,String maxPrice) {
		lowPriceFilter.sendKeys(minPrice);
		highPriceFilter.sendKeys(maxPrice+"\n");
		
	}

	public ProductPage selectItem(int i) {
		driver.findElement(By.xpath("(//*[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"])["+i+"]")).click();
		return new ProductPage();
	}
	
	
	
	
}
