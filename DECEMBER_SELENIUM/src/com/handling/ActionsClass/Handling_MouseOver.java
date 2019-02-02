package com.handling.ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_MouseOver 
{
	/*
	 Using Actions  Class we can perform
	 1. Mouse Over operations
	 2. Mouse Right Click
	 3. Drag And Drop Operations
	 4. Resizable
	 5. Slider
	  
	 Actions Class Methods
	 moveToElement(), contextClick(), doubleClick(), dragAndDrop(), dragAndDropBy(), 
	 release(), build(), perform(), clickAndHold()  
	 */
	
	   public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("http://www.way2automation.com/index.html");
		  Assert.assertEquals(driver.getTitle(), "Best Selenium Training - Rahul Arora (Raman) | Selenium Training Institute in Noida, Delhi, Gurgaon, Ghaziabad");
		  
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.linkText("COURSES"))).build().perform();
		  
		  driver.findElement(By.linkText("Jmeter")).click();
		  
		  if (driver.getTitle().equals("Class- Room Jmeter Training in Noida, Delhi, Gurgaon & NCR, Expert level Jmeter Training"))
		  {
			  System.out.println("TEST PASSED");
			
		} else 
		{
			System.out.println("TEST FAILED");
		}
		
		driver.close();
	}
}
