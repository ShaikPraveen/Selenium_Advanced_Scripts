package com.handling.StaleElementReferenceException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_StaleElementReferenceException 
{
	//Video Link :: https://www.youtube.com/watch?v=m558zwIM-bU
	public static void main(String[] args)
	{
		//Stale means old, decayed, and no longer fresh
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://www.freecrm.com/index.html");
		Assert.assertEquals(driver.getTitle(), "#1 Free CRM software in the cloud for sales and service");
		
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys("Praveen1177");
		
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("123456");
		
		
		driver.navigate().refresh();
		try
		{
		username.sendKeys("Praveen1177");
		}catch(StaleElementReferenceException e)
		{
			System.out.println("PROBLEM SOLVED");	
		}
	}
}
