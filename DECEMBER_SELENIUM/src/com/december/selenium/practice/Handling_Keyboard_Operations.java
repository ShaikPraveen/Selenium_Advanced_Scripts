package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Handling_Keyboard_Operations
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Google");
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Gmail")));
		act.contextClick();
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.ENTER);
		act.build().perform();	
	}
}
