package com.handling.ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_DranAndDrop
{
	public static void main(String[] args)
	{
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		  Assert.assertEquals(driver.getTitle(), "Demo 2: Drag and drop");
		  
		  WebElement source_element=driver.findElement(By.xpath("//div[@id='box1']"));
		  WebElement target_element=driver.findElement(By.xpath("//div[@id='box106']"));
		  
		  Actions act=new Actions(driver);
		  //1. First Method
		  act.clickAndHold(source_element).moveToElement(target_element).release().build().perform();
		  
		  //2.Second Method
		  act.dragAndDrop(source_element, target_element);
	}

}
