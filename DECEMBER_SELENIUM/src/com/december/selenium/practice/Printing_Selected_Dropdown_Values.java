package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Printing_Selected_Dropdown_Values 
{
	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		
		Select month=new Select(driver.findElement(By.id("month")));
		WebElement option=month.getFirstSelectedOption();
		String defaultselectedOption=option.getText();
		System.out.println("DEFAULT SELECTED OPTION IS "+defaultselectedOption);
		
		month.selectByIndex(2); //Feb
		WebElement option1=month.getFirstSelectedOption();
		String afterseletedOption=option1.getText();
		System.out.println("AFTER SELECTED ITEM IS "+afterseletedOption);
		
		//Sleeper.sleepTight(2);
		month.selectByValue("4");//Apr
		WebElement option2=month.getFirstSelectedOption();
		String afterseletedOption1=option2.getText();
		System.out.println("AFTER SELECTED ITEM IS "+afterseletedOption1);
		
		//Sleeper.sleepTight(2);
		month.selectByVisibleText("Sept");
		WebElement option3=month.getFirstSelectedOption();
		String afterseletedOption2=option3.getText();
		System.out.println("AFTER SELECTED ITEM IS "+afterseletedOption2);
		
		Assert.assertEquals(pageTitle, driver.getTitle());
		driver.close();
	}
}
