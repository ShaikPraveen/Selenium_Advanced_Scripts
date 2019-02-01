package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Number_Of_Radiobuttons
{
	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
		
		List<WebElement> numberofradios=driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("NUMBER OF RADIO BUTTONS IN WEBPAGE IS "+numberofradios.size());
		
		for (int i = 0; i < numberofradios.size(); i++)
		{
			WebElement radio_names=numberofradios.get(i);
			String id=radio_names.getAttribute("id");
			System.out.println("THE NAMES OF THE TOTAL RADIO BUTTONS ARE "+id);	
		}
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.goibibo.com/");
		driver.close();	
	}
}
