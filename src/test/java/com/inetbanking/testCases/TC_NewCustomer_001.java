package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewCustomerPage;

public class TC_NewCustomer_001 extends BaseClass {
	
	@Test
	public void TC_NewCustomer001() throws IOException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		NewCustomerPage ncp = new NewCustomerPage(driver);
		lp.login(username, password);
		hp.clickNewCustomer();
		ncp.inputNewCustomer("thao", "f", "09/09/1999", "22 Tanhs LInh VN", "HCM", "Binh Thanh","123456789", "0989999", randomString() + "@gmail.com", "123456789");
		logger.info("Inputed new customer's information");
		
		ncp.clickSubmit();
		logger.info("Clicked submit");
		
		if(ncp.isAddingNewCustomerSuccessfully()) {
			Assert.assertTrue(true);
			logger.info("TC passed");
		}else {
			logger.warn("TC failed");
			captureScreen("TC_NewCustomer001");
			Assert.assertTrue(false);
		}
	}
}
