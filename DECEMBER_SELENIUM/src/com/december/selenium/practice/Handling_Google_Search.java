package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Google_Search 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Google");
		
		driver.findElement(By.xpath("//input[@type='text'][@name='q']")).sendKeys("selenium");
	
	    Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbai']"));
	    System.out.println(list.size());
	    
	   for (int i = 0; i < list.size(); i++)
	   {
		   String listnames=list.get(i).getText();
		   System.out.println(listnames);
		   
		   if (listnames.contains("selenium ide"))
		   {
			   list.get(i).click();
			   break;
		}
		}
	}
}
