package com.handling.encoding.password;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Encode_Password 
{
	public static void main(String[] args)
	{
		//Now we can use this Feature in Selenium Automation
		//Suppose When you automating the Logins, we need to provide Password as well
		//Now you don't want to visible your password to others
		//Now just the Password as a Encoded Format
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://acegrades.com/");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		driver.findElement(By.linkText("LOG IN")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sample@teacher.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(decodestring("MTIzNDU2"));
		driver.findElement(By.xpath("//button[@id='loginId']")).click();
		
		if (driver.findElement(By.xpath("//span[@class='txt ng-binding']")).isDisplayed())
		{
			System.out.println("TEACHER DASHBOARD IS VISIBLE");
			
		} else
		{
          System.out.println("NOT TEACHER DASHBOARD IS NOT VISIBLE");
		}
		
		driver.close();
	}
	
	public  static String decodestring(String password)
	{
		byte[] decodedstring = Base64.decodeBase64(password);
		return (new String(decodedstring));
	}
}
