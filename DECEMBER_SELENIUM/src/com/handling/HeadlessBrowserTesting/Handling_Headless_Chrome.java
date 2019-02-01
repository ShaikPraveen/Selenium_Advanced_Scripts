package com.handling.HeadlessBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handling_Headless_Chrome 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
	
		 ChromeOptions options=new ChromeOptions();
		 //options.setHeadless(true);
		 options.addArguments("--headless");
	
		WebDriver driver=new ChromeDriver(options); //Always it will open Browser and Navigate to URL, I don't want to see Browser. Please check above code
		driver.get("https://www.acegrades.com");
		System.out.println(driver.getTitle());	
	}
}
