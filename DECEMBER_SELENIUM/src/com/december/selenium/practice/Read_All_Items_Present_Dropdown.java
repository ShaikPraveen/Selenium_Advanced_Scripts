package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Read_All_Items_Present_Dropdown {

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
		
		Select monthselct=new Select(driver.findElement(By.id("month")));
		
		List<WebElement> monthlist=monthselct.getOptions();
		System.out.println("TOTAL NUMBER OF MONTHS ARE "+monthlist.size());
		
		for (int i = 0; i < monthlist.size(); i++)
		{
		  String monthNames =	monthlist.get(i).getText();
		  System.out.println("MONTH NAMES ARE "+ monthNames);	
		}
		
		Assert.assertEquals(pageTitle, driver.getTitle());
		driver.close();
	}
}
