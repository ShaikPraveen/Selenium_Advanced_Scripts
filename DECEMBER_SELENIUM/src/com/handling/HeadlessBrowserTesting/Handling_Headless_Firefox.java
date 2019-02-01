package com.handling.HeadlessBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Handling_Headless_Firefox 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\geckodriver.exe");
		
		FirefoxOptions options=new FirefoxOptions();
		//options.setHeadless(true);
		options.addArguments("--headless");
		
		WebDriver driver=new FirefoxDriver(options);
		driver.get("https://www.acegrades.com");
		System.out.println(driver.getTitle());
	}
}
