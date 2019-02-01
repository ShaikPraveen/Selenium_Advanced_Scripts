package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Dropdown2 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		WebElement day= driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
		
     //How will you select the value without using Select Class, By using findElements() Method
		List<WebElement> monthlist=driver.findElements(By.xpath("//select[@id='month']//option"));
		System.out.println(monthlist.size());
		
		for (int i = 0; i < monthlist.size(); i++) 
		{
			String monthNmaes=monthlist.get(i).getText();
			System.out.println(monthNmaes);
			if (monthlist.get(i).getText().equals("Sept"))
			{
				monthlist.get(i).click();
				break;	
			}
			
		}
		
		
	}

}
