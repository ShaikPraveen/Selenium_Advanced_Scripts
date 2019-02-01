package com.handling.WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_WebTable1 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.xpath("//a[contains(text(),'User Management')]")).click();
		driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']")).click();
		
		//COUNT ROWS
		int rows=driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[4]/table[1]/tbody[1]/tr")).size();
		System.out.println("NUMBER OF ROWS ARE :"+rows);
		
		//COUNT NUMBER OF USERS ARE ENABLED
		
		int statuscount = 0;
		
		for (int i = 1; i<=rows; i++) 
		{
			String status = driver.findElement(By.xpath("//*[@id='resultTable']/tbody[1]/tr[" +i+ "]/td[5]")).getText();
			
			if (status.equals("Enabled"))
			{
				statuscount = statuscount + 1;
				
			}
		}
		System.out.println("NUMBER OF EMPLOYEES ENABLED : "+statuscount);
		driver.close();	
	}
}
