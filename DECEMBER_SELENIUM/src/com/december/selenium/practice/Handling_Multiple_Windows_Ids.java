package com.december.selenium.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Multiple_Windows_Ids
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://www.winnowit.in/");
		Assert.assertEquals(driver.getTitle(), "Winnow It Services");
		
		driver.findElement(By.linkText("Employee Login")).click();
	    Set<String> window_ids	=driver.getWindowHandles();
	    System.out.println("NUMBER OF WINDOW ID'S ARE "+window_ids);
	    
	    Iterator<String> it=window_ids.iterator();
	    while (it.hasNext()) 
	    {
	    	String windowid=it.next();
	    	System.out.println("WINDOW ID "+windowid);
			
		}
	}

}
