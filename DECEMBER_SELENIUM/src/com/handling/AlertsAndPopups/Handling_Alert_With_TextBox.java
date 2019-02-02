package com.handling.AlertsAndPopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Alert_With_TextBox
{
	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("http://demo.automationtesting.in/Alerts.html");
		  Assert.assertEquals(driver.getTitle(), "Alerts");
		  
		  driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		  
		  driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		  
		  driver.switchTo().alert().sendKeys("TESTING");
		  
		  driver.switchTo().alert().accept();
		  
		  /*String exp_text="Hello Automation Testing user How are you today";
		  String act_text=driver.findElement(By.xpath("//p[@id='demo1']")).getText();
		  
		  if (exp_text.contains(act_text)==true)
		  {
			  System.out.println("TEST PASED");
		}*/
		  
		  WebElement status_text=driver.findElement(By.xpath("//p[@id='demo1']"));
		  Assert.assertTrue(status_text.isDisplayed(),"STATUS TEXT IS NOT DISPAYED");
		  
		  driver.close();
	}
}
