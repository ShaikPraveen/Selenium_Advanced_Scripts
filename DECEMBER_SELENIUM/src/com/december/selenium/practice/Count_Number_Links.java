package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Count_Number_Links
{
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Praveen_Automation\\Selenium_Latest\\Gecko_Driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		 
		// System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Selenium_Latest\\chromedriver.exe");
		// WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  
		driver.get("https://www.seleniumhq.org/download/");
		String pageTitle= driver.getTitle();
		System.out.println("PAGE TITLE IS "+pageTitle);
	
		List<WebElement> links=driver.findElements(By.tagName("a"));
		links.size();
		System.out.println("TOTAL NUMBER OF LINKS ARE "+links.size());
		
		for (int i = 0; i < links.size(); i++) 
		{
			String linkNames=links.get(i).getText();
			System.out.println("LINKS NAME IS =>"+linkNames);
			
		}
		
		driver.close();
	}
}
