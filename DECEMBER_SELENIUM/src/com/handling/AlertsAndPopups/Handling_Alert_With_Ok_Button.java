package com.handling.AlertsAndPopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Alert_With_Ok_Button
{
	/*
	 To Handle Alerts 3 Types like
	 1. Alert with OK Button
	 2. Alert with OK and Cancel Buttons
	 3. Alert with TextBox
	 */
	//Video Link :: https://www.youtube.com/watch?v=Ndrx0ZRNWx0&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=16
	public static void main(String[] args)
	{
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("http://demo.automationtesting.in/Alerts.html");
		  Assert.assertEquals(driver.getTitle(), "Alerts");
		  
		  driver.findElement(By.xpath("//li[@class='active']//a[@class='analystic'][contains(text(),'Alert with OK')]")).click();
		  
		  driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		  
		  String alert_text= driver.switchTo().alert().getText();
		  
		  driver.switchTo().alert().accept();
		  
	
		  if (alert_text.contains("I am an alert box!")) 
		  {
			  System.out.println("TEST PASS");
			
		} else
		{
			System.out.println("TEST FAIL");
		}
	}

}
