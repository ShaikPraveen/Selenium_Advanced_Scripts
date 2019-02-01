package com.handling.TextBoxOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TextBox_Operations 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://acegrades.com");
		String pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "ACEGRADES");
		driver.findElement(By.linkText("LOG IN")).click();
		
		driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("demo@teacher.com");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@id='loginId']")).click();
        Thread.sleep(3000);
        
        boolean b =driver.findElement(By.xpath("//img[@class='left logo']")).isDisplayed();  
        Assert.assertTrue(b);
        
        driver.findElement(By.xpath("//span[@class='txt ng-binding']")).click();
        driver.findElement(By.xpath("//a[@id='editprofile_id']")).click();
	}
}
