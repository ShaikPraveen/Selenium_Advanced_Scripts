package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_Dropdown1
{
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		WebElement day= driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
		
		Select select=new Select(day);
		select.selectByIndex(10);
		
	//If you want to select multiple values in Drop down using isMultple() Method, the return type is Boolean
		
		//Check the Day drop down is Multiple drop down or not
		System.out.println(select.isMultiple());
		
		//Count all values from Day drop down using getOptions(), the return type is list of webelements
		List<WebElement> dayslist=select.getOptions();
		System.out.println(dayslist.size());
		int Totaldays=dayslist.size()-1;
		System.out.println("Total Number Of Days Are: "+ Totaldays);
		
		//Read all items Present in Day drop down using For loop
		for (int i = 0; i < dayslist.size(); i++)
		{
			String dayvalue=dayslist.get(i).getText();
			System.out.println(dayvalue);
		//How will you select specific value from drop down using getOption() Method
			if (dayvalue.equals("20")) 
			{
				dayslist.get(i).click();
				break;	
			}	
		}
		
	}

}
