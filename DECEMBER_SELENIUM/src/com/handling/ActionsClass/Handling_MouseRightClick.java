package com.handling.ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_MouseRightClick
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		  Assert.assertEquals(driver.getTitle(), "jQuery contextMenu (2.x)");
		  
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"))).contextClick().build().perform();
		  
		  //Click Copy option 
		  driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();
		  
		  //Copy the Alert Text 
		  
		  String copyText=driver.switchTo().alert().getText();
		  System.out.println(copyText);
		  
		  //Close the Alert
		  driver.switchTo().alert().accept();
		  
		  if (copyText.contains("clicked: copy")) 
		  {
			  System.out.println("TEST PASS");
			
		} else
		{
			System.out.println("TEST FAIL");
		}
		  
		  driver.close();	  
	}
}
