package com.handling.TestNG.Assertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_Hard_Assert 
{
	
	@Test
	public void ace_LoginTest()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.acegrades.com");
		String expTitle="ACEGRADES";
		Assert.assertEquals(expTitle, driver.getTitle());
		
		WebElement login=driver.findElement(By.linkText("LOG IN"));
		Assert.assertTrue(login.isDisplayed());
		login.click();
        
		WebElement username=driver.findElement(By.id("email"));
		WebElement password=driver.findElement(By.id("password"));
		
		Assert.assertTrue(username.isDisplayed());
		username.sendKeys("demo@teacher.com");
		
		Assert.assertTrue(password.isDisplayed());
		password.sendKeys("123456");
		
		driver.findElement(By.id("loginId")).click();
		
		WebElement classeslink=driver.findElement(By.xpath("//a[@ui-sref='teacher_classes']"));
		Assert.assertTrue(classeslink.isDisplayed());
		driver.close();
	}

}
