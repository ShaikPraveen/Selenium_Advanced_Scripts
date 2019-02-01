package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Capture_Hyperlink_Reference_Value 
{
	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://acegrades.com/");
		Assert.assertEquals(driver.getTitle(),"ACEGRADES");
		
		String hrefval;
		hrefval=driver.findElement(By.linkText("LOG IN")).getAttribute("href");
		System.out.println(hrefval);
		
		driver.close();
	}
}
