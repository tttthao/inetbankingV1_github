package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExcelUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd) throws IOException {
		System.out.println(user+"/"+ pwd);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.login(user, pwd);
		logger.info("Entered username, password");
		
		if(isAlertPresent()) {
			logger.warn("Login test failed");
			captureScreen("LoginDDT");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			hp.clickLogout();
			logger.info("Login test passed");	
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		String xlpath = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = ExcelUtils.getRowCount(xlpath, "Sheet1");
		int colnum = ExcelUtils.getCellCount(xlpath, "Sheet1", 1);
		System.out.printf("rownum=%d, colnum=%d",rownum, colnum);
		String logindata[][] = new String[rownum][colnum];
		for(int i=0;i<rownum;i++) {
			for(int j=0;j<colnum;j++) {
				logindata[i][j]=ExcelUtils.getCellData(xlpath, "Sheet1", i+1, j);
			}
		}
		return logindata;
	}

}
