package com.handling.ElementNotClickableAtPoint;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Element_NotClickable_AtPoint 
{
	//Video URL :: https://www.youtube.com/watch?v=iaI1vcEAWlM
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://www.freecrm.com/index.html");
		Assert.assertEquals(driver.getTitle(), "#1 Free CRM software in the cloud for sales and service");
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Praveen@1120");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//SCRIPT IS NOT COMPLTED YET
	}

}
