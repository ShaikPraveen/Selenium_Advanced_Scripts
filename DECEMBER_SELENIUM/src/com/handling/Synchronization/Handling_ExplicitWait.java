package com.handling.Synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Handling_ExplicitWait
{
	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.get("https://www.makemytrip.com/");
		  Assert.assertEquals(driver.getTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		  driver.findElement(By.linkText("HOMESTAYS")).click();
		  
		  WebDriverWait wait=new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='pull-right wallet-cta sign-up-myBiz']")));
		  
		  driver.findElement(By.xpath("//a[@class='pull-right wallet-cta sign-up-myBiz']")).click();	  
	}
}
