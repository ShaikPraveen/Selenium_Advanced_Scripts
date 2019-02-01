package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Frames
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		Assert.assertEquals(driver.getTitle(), "#1 Free CRM software in the cloud for sales and service");
		
		driver.findElement(By.xpath("//input[@class='form-control' and @name='username']")).sendKeys("Praveen1177");
		driver.findElement(By.xpath("//input[@class='form-control' and @name='password']")).sendKeys("praveen@1120");
		driver.findElement(By.xpath("//input[@class='btn btn-small' and @type='submit']")).click();
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
		driver.close();
	}
}
