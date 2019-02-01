package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Handling_Dropdowns 
{
	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		
		Select monthselect=new Select(driver.findElement(By.id("month")));
		
		monthselect.selectByIndex(2);//Feb
		//Sleeper.sleepTightInSeconds(2);
		monthselect.selectByValue("1");
		//Sleeper.sleepTightInSeconds(2);
		monthselect.selectByVisibleText("Sept");
		
		Assert.assertEquals(pageTitle, driver.getTitle());
		driver.close();
	}

}
