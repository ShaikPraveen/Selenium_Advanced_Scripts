package com.handling.ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_Resizable
{
	public static void main(String[] args)
	{	
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://jqueryui.com/resizable/");
		  Assert.assertEquals(driver.getTitle(), "Resizable | jQuery UI");
		  
		//here we have only one frame that's why i have used frame(0) index
		 driver.switchTo().frame(0);
		 
		 WebElement resizable_element=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		 
		 Actions act=new Actions(driver);
		 act.moveToElement(resizable_element).dragAndDropBy(resizable_element, 50, 50).build().perform();	
	}
}
