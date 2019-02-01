package com.handling.Log4J;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4J_Example
{
	public static void main(String[] args)
	{
		//Here we need to create logger instance so we need to pass class name
		
		Logger logger =Logger.getLogger("Log4J_Example");
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		logger.info("LAUNCH THE BROWSER");
		driver.manage().window().maximize();
		
		logger.info("NAVIGATE TO URL");
		driver.get("http://www.acegrades.com");
	}

}
