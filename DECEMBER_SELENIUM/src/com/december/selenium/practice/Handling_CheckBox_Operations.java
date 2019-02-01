package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

public class Handling_CheckBox_Operations 
{
	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://acegrades.com/");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		driver.findElement(By.linkText("LOG IN")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://acegrades.com/login.html");
		
		 WebElement remember_check=driver.findElement(By.xpath("//label[text()='Remember me']"));
		
		//Verify Check Box is Displayed or not in  web site
		 
		 boolean remembercheckbox_displayed=remember_check.isDisplayed();
		 System.out.println("IS REMEMBER ME CHECK BOX IS DISPLAYED ON THE WEBPAGE => "+remembercheckbox_displayed);
		 
		
		//Verify Check Box is Enabled   or not in  web site
		 
		 boolean remembercheckbox_enabled=remember_check.isEnabled();
		 System.out.println("IS REMEMBER ME CHECK BOX IS ENABLED ON THE WEBPAGE => "+remembercheckbox_enabled);
		 
		//Verify Check Box is Selected  or not in  web site
		
		 boolean remembercheckbox_selected=remember_check.isSelected();
		 System.out.println("IS REMEMBER ME CHECK BOX IS SELECTED ON THE WEBPAGE => "+remembercheckbox_selected);
		
		 remember_check.click();
		 //Sleeper.sleepTightInSeconds(2);
		 
		//Verify New Status
		 boolean remembercheckbox_newstatus=remember_check.isSelected();
         System.out.println("IS REMEMBER ME CHECKBOX IS SELECTED ON THE WEBPAGE => "+remembercheckbox_newstatus);

        Assert.assertEquals(driver.getCurrentUrl(), "https://acegrades.com/login.html");
        driver.close();
	}
}
