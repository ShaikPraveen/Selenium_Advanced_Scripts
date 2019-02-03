package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Calender_WithDate
{
	//Rahul Shetty :: 10
	public static void main(String[] args) 
	{
		//THIS SCRIPT WILL SELECT ONLY DATE
		
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://www.path2usa.com/travel-companions");
		  Assert.assertEquals(driver.getTitle(), "Travel Companion - Find a Travel Companion for Your Next Trip to USA");
		  
		  driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		  
		  //My Target Select 23 December 2019 
		  
		  //Count Number of dates
		  List<WebElement> days=driver.findElements(By.className("day")); 
		  int count=driver.findElements(By.className("day")).size();
		  
		  for (int i = 0; i < count; i++)
		  {
			String text=  driver.findElements(By.className("day")).get(i).getText();
			
			if (text.equalsIgnoreCase("23"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;	
			}
		  }	  
	}

}
