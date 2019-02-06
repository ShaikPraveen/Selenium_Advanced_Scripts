package com.handling.DynamicWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_GoogleSearch_Webelements 
{
	
    public static void main(String[] args)
    {
    	System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    	
    	driver.get("https://www.google.com/");
    	Assert.assertEquals(driver.getTitle(), "Google");
    	
    	driver.findElement(By.xpath("//input[@title='Search']")).clear();
    	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");
    	
    	
    	List<WebElement> ele= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
    	System.out.println(ele.size());
    	
    	
    	for (int i = 0; i <ele.size(); i++)
    	{
    		System.out.println(ele.get(i).getText());
    		
    		if (ele.get(i).getText().contains("selenium download"))
    		{
    			ele.get(i).click();
    			break;
    		}
    	}
    	
    	//driver.close();
    }
}
