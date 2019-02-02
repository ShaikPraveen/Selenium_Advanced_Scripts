package com.handling.ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_MouseOver1
{
	//Video Link :: https://www.youtube.com/watch?v=UlOREVRHpYs&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=17
	public static void main(String[] args)
	{
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		  
		  driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		  driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		  
		  Actions act=new Actions(driver);
		  
		  WebElement admin=driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
		  WebElement usermgnt=driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
		  WebElement users=driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"));
		  
		  /*act.moveToElement(admin).build().perform();
		  act.moveToElement(usermgnt).build().perform();
		  act.moveToElement(users).click().build().perform();*/
		  
		  //HOW TO REDUCE THE CODE
		  act.moveToElement(admin).moveToElement(usermgnt).moveToElement(users).click().build().perform();
		  
		  
		  if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers"))
		  {
			  System.out.println("TEST PASS");
			
		} else 
		{
			System.out.println("TEST FAIL");
		}
		  
		  driver.close();
	}
}
