package com.handling.AlertsAndPopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Alert_With_Ok_And_Cancel_Button
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
		  
		  driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
		  
		  driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		  
		  String alert_text= driver.switchTo().alert().getText();
		  System.out.println(alert_text);
		  
		  String expTextOK="You pressed Ok";
		  String expTextCANCEL="You Pressed Cancel";
		 
		  //OK Button Test Case
		  driver.switchTo().alert().accept();
		  
		  String actText = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		  
		  if (expTextOK.equals(actText)==true) 
		  {
			System.out.println("TEST PASSED " +actText);
		  }
		 
		  
		  //CANCEL Button TestCase
		  driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			 
		  driver.switchTo().alert().dismiss();
		 
		  String actText1 = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		 
		  if (expTextCANCEL.equals(actText1)==true)
		  {
			System.out.println("TEST PASSED "+actText1);
		}	
	}

}
