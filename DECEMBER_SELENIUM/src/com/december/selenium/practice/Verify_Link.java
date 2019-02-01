package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Verify_Link 
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://acegrades.com/");
		String pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "ACEGRADES");
		
		List<WebElement> pageLinks=driver.findElements(By.tagName("a"));
		System.out.println(pageLinks.size());
		
		String explink,actlink;
		       explink="CONTACT";
	   boolean linkexist=false;
		
		for (int i = 0; i< pageLinks.size(); i++)
		{
			actlink=pageLinks.get(i).getText();
			//System.out.println("LINK NAME IS "+linkNames);
			
			if (explink.equalsIgnoreCase(actlink)) 
			{
				
				linkexist=true;
				break;
			}
		}
		if (linkexist)
		{
			System.out.println("TEST PASS");
			
		} else 
		{
			System.out.println("TEST FAIL");

		}
		
		driver.close();	
	}
}
