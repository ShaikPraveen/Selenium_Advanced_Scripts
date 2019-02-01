package com.handling.ScrollingWebpage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_ScrollingWebpage
{
	//Video Link :: https://www.youtube.com/watch?v=czWJ7UGuTkQ&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=28
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://www.countries-ofthe-world.com/all-countries.html");
		Assert.assertEquals(driver.getTitle(), "List of countries of the world in alphabetical order");
	    
		JavascriptExecutor js=(JavascriptExecutor)driver;
		// 1. Scrolling By using Pixel
		//js.executeScript("window.scrollBy(0,1000)", "");
		
		//2. Scrolling page till we find an Element
		//WebElement element = driver.findElement(By.xpath("//li[contains(text(),'Brazil')]"));
		//js.executeScript("arguments[0].scrollIntoView();",element);
		
		//3. Scroll page till bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
