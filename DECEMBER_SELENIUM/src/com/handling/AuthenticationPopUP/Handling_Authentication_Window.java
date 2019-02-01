package com.handling.AuthenticationPopUP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Authentication_Window 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//http://username:password@test.com
		
		String text = driver.findElement(By.cssSelector("p")).getText();
		
		if (text.contains("Congratulations! You must have the proper credentials.")) 
		{
			System.out.println(text+ "TEXT IS PRESENT, TEST PASS");
		} else 
		{
			System.out.println(text+ "TEXT IS NOT PRESENT, TEST FAIL");

		}
		
		driver.close();
	}

}
