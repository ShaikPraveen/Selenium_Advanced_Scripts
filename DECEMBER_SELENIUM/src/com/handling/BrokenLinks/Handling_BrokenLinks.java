package com.handling.BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_BrokenLinks 
{
	//Video Link :: https://www.youtube.com/watch?v=E0gvFxM6qTw&index=18&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://www.newtours.demoaut.com/");
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
		
		//driver.get("http://www.acegrades.com/");
		//Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		
		for (int i = 0; i<alllinks.size(); i++) 
		{
			//PRINT ALL LINK NAMES
			//System.out.println(alllinks.get(i).getText());
			
			
			//BY USINH href ATTRIBUTE WE CAN GET URL OF THE REQUIRED LINK
			WebElement element = alllinks.get(i);
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			//Create a Connection using url Object link
			HttpURLConnection httpconn = (HttpURLConnection)link.openConnection();
			
			Thread.sleep(2000);
			httpconn.connect();
			
			int rescode = httpconn.getResponseCode(); //return response code: if response code is above 400 : broken link
			
			if (rescode>=400) 
			{
				System.out.println(url+" - "+" IS BROKEN LINK");
				
			} else
			{
				System.out.println(url+" - "+" IS VALID LINK");
			}
		}
		
		driver.close();
	}

}
