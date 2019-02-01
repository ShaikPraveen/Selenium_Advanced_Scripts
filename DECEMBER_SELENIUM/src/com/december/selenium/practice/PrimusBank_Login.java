package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class PrimusBank_Login 
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
		
		driver.get("http://primusbank.qedgetech.com");
		String pageTitle=driver.getTitle();
		System.out.println("TITLE OF THE PAGE "+pageTitle);
		Assert.assertEquals(pageTitle, driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		String pageURL=driver.getCurrentUrl();
		System.out.println("PAGE URL IS "+pageURL);
		
		Assert.assertEquals(pageURL, driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
	    driver.close();
	}
}
