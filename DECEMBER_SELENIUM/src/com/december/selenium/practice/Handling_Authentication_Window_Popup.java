package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Authentication_Window_Popup 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String textname=driver.findElement(By.cssSelector("p")).getText();
		System.out.println(textname);
		
		//syntax : http://username:password@test.com
		
		Assert.assertEquals(driver.getTitle(), "The Internet");
		driver.close();
	}
}
