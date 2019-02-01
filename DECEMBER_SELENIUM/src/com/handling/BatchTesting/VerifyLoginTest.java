package com.handling.BatchTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLoginTest 
{
	@Test
	public void loginTest()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String title="OrangeHRM";
		Assert.assertEquals(title, driver.getTitle());
		
		WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		Assert.assertTrue(username.isDisplayed());
		username.sendKeys("Admin");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		Assert.assertTrue(password.isDisplayed());
		password.sendKeys("admin123");
		
		WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		Assert.assertTrue(loginBtn.isDisplayed());
		loginBtn.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		driver.close();	
	}

}
