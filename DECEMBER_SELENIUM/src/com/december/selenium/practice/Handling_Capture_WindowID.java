package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Capture_WindowID 
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://www.winnowit.in/");
		Assert.assertEquals(driver.getTitle(), "Winnow It Services");
		
		String window_id=driver.getWindowHandle();
		System.out.println("CURRENT WINDOW ID IS "+window_id);
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.winnowit.in/");
		driver.close();	
	}
}
