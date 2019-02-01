package com.screenrecorder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AceLoginTest 
{
	static WebDriver driver;
	static String url ="https://acegrades.com";
	
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
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
	}
	
	@Test
	public void loginTest() throws Exception
	{
		ScreenRecorderUtil.startRecord("loginTest");
		driver.findElement(By.linkText("LOG IN")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sample@teacher.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='loginId']")).click();
		
		if (driver.findElement(By.xpath("//a[@class='dropdown-button add-class']")).isDisplayed()) 
		{
			System.out.println("TEST PASS");
			
		} else 
		{
			System.out.println("TEST FAIL");

		}
		
		ScreenRecorderUtil.stopRecord();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
