package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
			pro = new Properties();
			try {
				pro.load(new FileInputStream(new File("./Configurations/config.properties")));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public String getApplicationURL() {
		return pro.getProperty("baseURL");
	}
	
	public String getUsername() {
		return pro.getProperty("username");
	}

	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getChromepath() {
		return pro.getProperty("chromepath");
	}
	
	public String getIepath() {
		return pro.getProperty("iepath");
	}
	
	public String getFirefoxpath() {
		return pro.getProperty("firefoxpath");
	}
}
