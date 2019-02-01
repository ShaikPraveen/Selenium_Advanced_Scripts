package com.handling.FileUpload;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_FileUpload 
{
	public static void main(String[] args) throws IOException 
	{
	   System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://www.tinyupload.com/");
		Assert.assertEquals(driver.getTitle(), "TinyUpload.com - best file hosting solution, with no limits, totaly free");
		
		driver.findElement(By.xpath("//input[@name='uploaded_file']")).click();
		
		Runtime.getRuntime().exec("E:\\Praveen_Automation\\AutoIt_Programs\\Fileupload_Practice1.exe");	

		driver.findElement(By.xpath("//img[@src='images/button_upload.gif']")).click(); 
		
	}
}
