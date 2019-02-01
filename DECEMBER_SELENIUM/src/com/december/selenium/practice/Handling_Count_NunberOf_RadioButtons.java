package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Count_NunberOf_RadioButtons 
{
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		
		List<WebElement> radios=driver.findElements(By.tagName("Select"));
		System.out.println("NUMBER OF RADIOS BUTTONS ARE "+radios.size());
		driver.close();
	}
}
