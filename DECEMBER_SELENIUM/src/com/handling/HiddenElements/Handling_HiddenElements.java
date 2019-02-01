package com.handling.HiddenElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_HiddenElements
{
	//Video URL :: https://www.youtube.com/watch?v=mkpDWFFFfBE
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://learn.letskodeit.com/p/practice");
		Assert.assertEquals(driver.getTitle(), "Practice | Let's Kode It");
		
		WebElement textbox=driver.findElement(By.xpath("//input[@id='displayed-text']"));
		System.out.println("TEXT BOX  STATUS IS "+textbox.isDisplayed());
		
		WebElement hidebutton=driver.findElement(By.xpath("//input[@id='hide-textbox']"));
		hidebutton.click();
		System.out.println("CLICKED HIDE BUTTON");
		System.out.println("TEXT BOX STATUS IS "+textbox.isDisplayed());
		
		WebElement showbutton=driver.findElement(By.xpath("//input[@id='show-textbox']"));
		showbutton.click();
		System.out.println("CLICKED SHOW BUTTON");
		System.out.println("TEXT BOX STATUS IS "+textbox.isDisplayed());
		
		driver.close();
		
	}

}
