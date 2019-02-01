package com.handling.MicrosoftEdgeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class Handling_MicrosoftEdgeDriver 
{
	//Video URL :: https://www.youtube.com/watch?v=Q56h7D54JSE
	public static void main(String[] args)
	{
		System.setProperty("webdriver.edge.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\MicrosoftWebDriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.acegrades.com");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");	
		
		//So finally this script will shows an error like
		//org.openqa.selenium.WebDriverException
	}
}
