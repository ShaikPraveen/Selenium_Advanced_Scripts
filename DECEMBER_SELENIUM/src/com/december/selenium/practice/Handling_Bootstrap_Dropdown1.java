package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Bootstrap_Dropdown1
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.winnowit.in/");
		Assert.assertEquals(driver.getTitle(), "Winnow It Services");
		
		driver.findElement(By.linkText("Services")).click();
		List<WebElement> services_menu=driver.findElements(By.xpath("html/body/div[2]/div/nav/div/div[2]/ul/li[3]/ul/li/a"));
		System.out.println("NUMBER OF ITEMS IN SERVICES MENU IS "+services_menu.size());
		
		for (int i = 0; i < services_menu.size(); i++) 
		{
			String services_menu_names=services_menu.get(i).getText();
			System.out.println("SERVICE MENU NAMES "+services_menu_names);
			
			WebElement ele=services_menu.get(i);
			String innerhtml=ele.getAttribute("innerHTML");
			
			if (innerhtml.contentEquals("E-Commerce"))
			{
				ele.click();
				break;	
			}
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.winnowit.in/e-commerce.html");
		driver.close();	
	}
}
