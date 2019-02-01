package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_RadioButtons
{
	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
		
		driver.findElement(By.xpath("//input[@id='gi_roundtrip_label' and @type='radio']")).click();
		
		if (driver.findElement(By.xpath("//input[@id='gi_roundtrip_label' and @type='radio']")).isSelected()) 
		{
			System.out.println("TEST PASS");
			
		} else
		{
			System.out.println("TEST FAIL");
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.goibibo.com/");
		driver.close();
	}
}
