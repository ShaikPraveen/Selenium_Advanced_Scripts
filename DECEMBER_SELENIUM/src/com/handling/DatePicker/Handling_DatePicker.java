package com.handling.DatePicker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_DatePicker 
{
	//Video URL :: https://www.youtube.com/watch?v=uzvQJrplZB8
	public static void main(String[] args) throws InterruptedException
	{
		String month ="December 2020";
		String day ="20";
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://www.phptravels.net/");
		Assert.assertEquals(driver.getTitle(), "PHPTRAVELS | Travel Technology Partner");
		
		driver.findElement(By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']")).click();
	   
		Thread.sleep(3000);
		
		while(true)
		{
		String text =driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
		 
		    if (text.equals(month)) 
		    {
		    	break;
				
			} else 
			{
				driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
			}
		}
		
		 driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),"+day+")]")).click();
	}

}
