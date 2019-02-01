package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handing_Mouse_Operations
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.navigate().to("https://colaninfotech.com/");
		Assert.assertEquals(driver.getTitle(), "Software Development Company | App Development Company – Colan Infotech");
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("EXPERTISE")));
		act.build().perform();
		driver.findElement(By.linkText("PHP")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://colaninfotech.com/php-development-company/");
		driver.close();	
	}
}
