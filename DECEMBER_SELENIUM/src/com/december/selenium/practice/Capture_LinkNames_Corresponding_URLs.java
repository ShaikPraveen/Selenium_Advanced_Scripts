package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Capture_LinkNames_Corresponding_URLs 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://acegrades.com/");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		List<WebElement> pageLinks=driver.findElements(By.tagName("a"));
		System.out.println("SIZE OF THE LINKS "+pageLinks.size());
		
		for (int i = 0; i < pageLinks.size(); i++)
		{
			String linkNames=pageLinks.get(i).getText();
			
			pageLinks.get(i).click();
			Thread.sleep(2000);
			String pageURL=driver.getCurrentUrl();
			System.out.println(linkNames +" = "+pageURL);
			
			driver.navigate().back();
			
			Thread.sleep(2000);
			
			pageLinks=driver.findElements(By.tagName("a"));
			
		}
	}

}
