package com.handling.BatchTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyLogoTest 
{
	//Video Link :: https://www.youtube.com/watch?v=v3wytFkIJz4&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=39

    @Test
	public void logoTest()
	{
    	System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String title="OrangeHRM";
		Assert.assertEquals(title, driver.getTitle());
		
		WebElement logo=driver.findElement(By.xpath("//img[@src='/webres_5bd6ae3dc0fea0.31921995/themes/default/images/login/logo.png']"));
		Assert.assertTrue(logo.isDisplayed());
		
		driver.close();	
	}
}
