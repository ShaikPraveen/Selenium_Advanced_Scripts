package com.handling.HashMap;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HashMap_Example 
{	
	//Video Link :: https://www.youtube.com/watch?v=x7AIIVFgQVw&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=37
	public static void main(String[] args)
	{
		//What is HashMap?
		//1. HashMap is a Collection in Java
		//2. In HashMap the Data will be stored in KEY and VALUE Format
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://www.newtours.demoaut.com/");
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
		
		String credentials=loginData().get("B");
		String arr[]=credentials.split("@");
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(arr[0]);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arr[1]);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");

       if (driver.getTitle().equals("Find a Flight: Mercury Tours:")) 
       {
    	   System.out.println("TEST PASSED");
		
	} else 
	{
		System.out.println("TEST FAILED");
	}
		driver.findElement(By.linkText("Home")).click();
		//Assert.assertEquals(driver.getCurrentUrl(), "http://newtours.demoaut.com/mercurywelcome.php");
		
		driver.close();
	}

	 public static HashMap <String,String> loginData()
	  {
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("A", "sample1120@sample11");
		hm.put("B", "PRAVEEN1120@PRAVEEN@1120");
		hm.put("C", "SULEMAN1120@SULEMAN@1120");
		
		return hm;
	}
}
