package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Textbox_Suggestions_List 
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com/");
		Assert.assertEquals(driver.getTitle(), "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
		
		driver.findElement(By.xpath("//input[@id='FromTag']")).clear();
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("ban");
		driver.findElement(By.xpath("//input[@id='FromTag']")).click();
		
		
		List<WebElement> citylist=driver.findElements(By.xpath("html/body/ul[1]/li/a"));
		System.out.println("NUMBER OF CITIES ARE "+citylist.size());
		
		for (int i = 0; i < citylist.size(); i++)
		{
			String citynames=citylist.get(i).getText();
			System.out.println("CITY NAMES ARE "+citynames);	
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.cleartrip.com/");
		driver.close();	
	}
}
