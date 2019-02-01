package com.handling.DisableElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Disable_Elements 
{
	//Video URL :: https://www.youtube.com/watch?v=1ifQ2ptQ_5o
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
		
		WebElement e1=driver.findElement(By.className("gLFyf gsfi"));
		e1.sendKeys("selenium");
		
	}

}
