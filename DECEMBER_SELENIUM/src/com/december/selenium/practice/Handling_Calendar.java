package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Calendar 
{

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.cleartrip.com/");
		Assert.assertEquals(driver.getTitle(), "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
		
		WebElement date=driver.findElement(By.xpath("//input[@id='DepartDate']"));
		String datevalue="Mon, 31 Dec, 2018";
		dateByJS(driver, date, datevalue);
	}
	
	public static void dateByJS(WebDriver driver,WebElement element, String datevalue)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute(value='DepartDate','"+datevalue+" ');",element);
	}
}
