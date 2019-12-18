package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	public WebDriver driver;
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="name")
	WebElement txtCusName;
	
	@FindBy(xpath="//input[@name='rad1' and @value='m']")
	WebElement rdoMale;
	
	@FindBy(xpath="//input[@name='rad1' and @value='f']")
	WebElement rdoFemale;
	
	@FindBy(name="dob")
	WebElement txtDate;
	
	@FindBy(name="addr")
	WebElement txtarAddress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="state")
	WebElement txtState;
	
	@FindBy(name="pinno")
	WebElement txtPin;
	
	@FindBy(name="telephoneno")
	WebElement txtMobileNumber;
	
	@FindBy(name="emailid")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	
		
	public void inputNewCustomer(String strCusName, String strGender, String strDateOfBirth, String strAddress, String strCity, String strState, String strPin, String strMobileNumber, String strEmail, String strPassword) {
		if(!strCusName.isEmpty()) {
			txtCusName.sendKeys(strCusName);
		}
		
		if(!strGender.isEmpty()) {
			if(strGender.equalsIgnoreCase("m"))
				rdoMale.click();
			else
				rdoFemale.click();
		}
		
		if(!strDateOfBirth.isEmpty())
			txtDate.sendKeys(strDateOfBirth);
		
		if(!strAddress.isEmpty())
			txtarAddress.sendKeys(strAddress);
		
		if(!strCity.isEmpty())
			txtCity.sendKeys(strCity);
		
		if(!strState.isEmpty())
			txtState.sendKeys(strState);
		
		if(!strPin.isEmpty())
			txtPin.sendKeys(strPin);
		
		if(!strMobileNumber.isEmpty())
			txtMobileNumber.sendKeys(strMobileNumber);
		
		if(!strEmail.isEmpty())
			txtEmail.sendKeys(strEmail);
		
		if(!strPassword.isEmpty())
			txtPassword.sendKeys(strPassword);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public boolean isAddingNewCustomerSuccessfully() {
		boolean blnSuccess = false;
		try {
			blnSuccess = driver.getPageSource().contains("Customer Registered Successfully");
		}catch(Exception e) {
			return false;
		}
		return blnSuccess;
	}

}
