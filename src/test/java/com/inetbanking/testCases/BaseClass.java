package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc = new ReadConfig();
	public String baseURL = rc.getApplicationURL();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	public WebDriver driver;
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger(this.getClass().getName());
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Configurations\\Log4j.properties");
		
		if(br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", rc.getChromepath());
			driver = new ChromeDriver();
		}else if(br.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxpath());
			driver = new FirefoxDriver();
		}else if(br.equals("ie")) 
		{
			InternetExplorerOptions IEOptions = new InternetExplorerOptions();
//			IEOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			IEOptions.ignoreZoomSettings();
			System.setProperty("webdriver.ie.driver", rc.getIepath());
			driver = new InternetExplorerDriver(IEOptions);
		}
		
		driver.get(rc.getApplicationURL());
		if(br.equals("ie")) {
			driver.navigate ().to ("javascript:document.getElementById('overridelink').click()");
		}
		logger.info("URL is opend");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(10);
	}
	
}
