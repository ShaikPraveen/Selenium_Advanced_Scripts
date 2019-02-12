package com.handling.PracticalExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Verify_Link_Type 
{
	
	public static void main(String[] args)
	{
	    WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\geckodriver.exe");
		//driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/");
		Assert.assertEquals(driver.getTitle(), "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
		driver.findElement(By.xpath("//input[@type='text' and @name='username']")).sendKeys("yourusername");
		driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("yourpassword");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).sendKeys(Keys.RETURN);
		
		
		String title=driver.getTitle();
		
		if (title.equals("CRMPRO"))
		{
			System.out.println("VERIFY TITLE TEST CASE PASS : TITLE MATCHED => "+title);
			Assert.assertTrue(true,"TEST PASS : TITLE MATCHED");
			
		} else
		{
			System.out.println("VERIFY TITLE TEST CASE FAIL : TITLE NOT MATCHED => "+title);
			Assert.assertTrue(false,"TEST FAIL : TITLE NOT MATCHED");
			
		}
		
		String url=driver.getCurrentUrl();
		
		if (url.contains(".com"))
		{   
			System.out.println("VERIFY URL CONTENT TEST CASE PASS : URL CONTAINS .COM => " +url);
			Assert.assertTrue(true,"TEST PASS  : URL CONTAINS .COM");
			
		} else
		{
			System.out.println("VERIFY URL CONTENT TEST CASE FAIL : URL NOT CONTAINS .COM => " +url);
			Assert.assertTrue(false,"TEST FAIL : URL NOT CONTAINS .COM");
			
		}
		
	    driver.close();	
	}

}
