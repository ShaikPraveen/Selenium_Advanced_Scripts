package com.screenrecorder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest 
{
	//Download Monte Screen Recorder Jar From Google -> Using Below Link -> Associate to Project
	//https://jar-download.com/artifacts/com.github.stephenc.monte/monte-screen-recorder/0.7.7.0/source-code

	static WebDriver driver;
	static String url ="http://demo.nopcommerce.com";
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get(url);
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
		
	}
	
	@Test
	public void verifyLink() throws Exception
	{
		ScreenRecorderUtil.startRecord("verifyLink");
		//Books Link
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[5]/a[1]")).click();
		System.out.println(driver.getTitle());
		
		//Computers Link
	    driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
	    System.out.println(driver.getTitle());
				
	    //Electronics Link
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		System.out.println(driver.getTitle());
				
				
		//Apparel Link
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")).click();
		System.out.println(driver.getTitle());
				
		//Digital Downloads Link
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[4]/a[1]")).click();
		System.out.println(driver.getTitle());
				
		//Books Link
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[5]/a[1]")).click();
		System.out.println(driver.getTitle());
		
		//Jewelry Link
	     driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[6]/a[1]")).click();
		 System.out.println(driver.getTitle());
		 
		//Gifts Cards Link
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[7]/a[1]")).click();
		System.out.println(driver.getTitle());
		
		ScreenRecorderUtil.stopRecord();		
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
