package com.handling.NoSuchElementFoundException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Handling_NoSuchElementFoundException 
{
	//Video URL :: https://www.youtube.com/watch?v=y6SYtAh-kCk
	public static void main(String[] args)
	{
		//Why this Exception Throws Mainly
		// 1. Time Issues
		// 2. Incorrect Locator or Type of Locator
		// 3. Element is in iframe
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://letskodeit.teachable.com/");
		Assert.assertEquals(driver.getTitle(), "Home | Let's Kode It");
		
		//1. Timing Issue
		driver.findElement(By.linkText("Login")).click();
		//driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("praveen@gmail.com");
		//The above statement shows an error, why because timing issues
		
		//To over come this Problem we use Implicit wait or Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement emailid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_email']")));
		emailid.sendKeys("praveen@gmail.com");
		
		driver.close();
	
	}

}
