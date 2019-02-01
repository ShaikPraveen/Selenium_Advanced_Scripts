package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_Drag_And_Drop 
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://jqueryui.com/droppable/");
		Assert.assertEquals(driver.getTitle(), "Droppable | jQuery UI");
		
		driver.switchTo().frame(0);
		Actions act=new Actions(driver);
		act.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']"))).moveToElement(driver.findElement(By.xpath("//div[@id='droppable']")));
		act.release().build().perform();
		
		
		
	}

}
