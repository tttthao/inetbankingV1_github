package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		logger.info("Entered username, password");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			logger.info("Login test passed");
			Assert.assertTrue(true);	
		}else
		{
			logger.info("Login test failed");
			captureScreen("loginTest");
			Assert.assertTrue(false);	
		}
				
	}
}
