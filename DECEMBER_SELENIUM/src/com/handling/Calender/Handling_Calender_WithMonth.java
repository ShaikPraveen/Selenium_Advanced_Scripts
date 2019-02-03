package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Calender_WithMonth 
{
	public static void main(String[] args) 
	{
		//THIS SCRIPT WILL SELECT BOTH MONTH AND DATE
		//THIS SCRIPT SHOWS SOME ERRORS, IT MAY BE XPATH ISSUES
		
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://www.path2usa.com/travel-companions");
		  Assert.assertEquals(driver.getTitle(), "Travel Companion - Find a Travel Companion for Your Next Trip to USA");
		  
		  driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		  
		  while(!driver.findElement(By.cssSelector("div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom:nth-child(7) div.datepicker-days table.table-condensed thead:nth-child(1) tr:nth-child(1) > th.datepicker-switch")).getText().contains("June"))
		  {
			  driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")).click();
		  }
		  List<WebElement> days=driver.findElements(By.className("day")); 
		  int count=driver.findElements(By.className("day")).size();
		  
		  for (int i = 0; i < count; i++)
		  {
			String text=  driver.findElements(By.className("day")).get(i).getText();
			
			if (text.equalsIgnoreCase("1"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;	
			}
		  }	  
	}
}
