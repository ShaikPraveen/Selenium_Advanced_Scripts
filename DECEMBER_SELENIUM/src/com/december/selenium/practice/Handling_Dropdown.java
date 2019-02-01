package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.ui.Select;

public class Handling_Dropdown 
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
		
		/*Select sel=new Select(day);
	    sel.selectByVisibleText("31");
	    
	    Select sel1=new Select(month);
	    sel1.selectByVisibleText("Sept");
	    
	    Select sel2=new Select(year);
	    sel2.selectByVisibleText("2019");*/
	    
	    //Actually we don't create select class again and again
	    //Suppose i have hundred drop downs
	    //we will create one Utility method
		
		/*selectValueFromDropdown(day, "25");
		selectValueFromDropdown(month, "Sept");
		selectValueFromDropdown(year, "2019");*/
		
		//Another way using String split() method
		
		String dob="31-Sept-2019";
		String arrDob[]=dob.split("-");
		selectValueFromDropdown(day, arrDob[0]);
		selectValueFromDropdown(month, arrDob[1]);
		selectValueFromDropdown(year, arrDob[2]);	
	}
	
	public static void selectValueFromDropdown(WebElement element, String value)
	{
		Select sele=new Select(element);
		sele.selectByVisibleText(value);	
	}
}
