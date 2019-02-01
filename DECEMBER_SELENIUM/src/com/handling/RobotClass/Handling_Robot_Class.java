package com.handling.RobotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Robot_Class 
{
	//WAP TO DOWOLOAD THE FILE USING ROBOT CLASS
	
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		//Chrome Browser
		driver.get("http://spreadsheetpage.com/index.php/site/file/yearly_calender_workbook");
		Assert.assertEquals(driver.getTitle(), "Excel Downloads From John Walkenbach");
		driver.findElement(By.xpath("//a[contains(text(),'xllightbox.xls')]")).click();
		
		//Firefox Browser
		//If you want to Download File in Firefox it will open Seperate window after click download link
		//Now will perform Keyboard operations
		//Here i am performing 3 operations like 1. Down arrow 2. Three times tab key 3. Click Enter Button
	 
	   //Now create Robot Class object
		
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_DOWN); //Press down the Keyboard
		    
		    Thread.sleep(2000);
		    
		    robot.keyPress(KeyEvent.VK_TAB);
		    Thread.sleep(2000);
		    robot.keyPress(KeyEvent.VK_TAB);
		    Thread.sleep(2000);
		    robot.keyPress(KeyEvent.VK_TAB);
		    Thread.sleep(2000);
		    
		    robot.keyPress(KeyEvent.VK_ENTER); //Press OK Button
		    
		    driver.close();
		    
	}

}
