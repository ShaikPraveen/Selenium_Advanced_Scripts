package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest
{
	public static void main(String[] args)
	{
		 //System.setProperty("webdriver.gecko.driver", "E:\\Praveen_Automation\\Selenium_Latest\\Gecko_Driver\\geckodriver.exe");
		 //WebDriver driver=new FirefoxDriver();
		 
		 System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Selenium_Latest\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 
		 driver.get("https://www.ultimatix.net");
		 String pageTitle=driver.getTitle();
		 System.out.println(" PAGE TITLE IS "+pageTitle);
		 
		 if (pageTitle.equals(driver.getTitle()))
          {
			 System.out.println("TEST PASS");
		
		} else
		{
			System.out.println("TEST FAIL");

		}
		 driver.close();
	}
}
