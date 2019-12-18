package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement lnkNewCustomer;
	
	public void clickNewCustomer() {
		lnkNewCustomer.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	

}
