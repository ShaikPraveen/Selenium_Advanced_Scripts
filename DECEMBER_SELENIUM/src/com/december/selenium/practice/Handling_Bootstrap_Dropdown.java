package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Bootstrap_Dropdown {

	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://www.softmindinformatics.com/");
		Assert.assertEquals(driver.getTitle(), "Softmind informatics Pvt Ltd");
		
		driver.findElement(By.linkText("Services")).click();
		
		List<WebElement> services_dropdown=driver.findElements(By.xpath("html/body/div[2]/nav/div/div[2]/ul/li[3]/ul/li/a"));
		System.out.println("NUMBER OF SERVICES BOOTSTRAP DROP DOWN IS "+services_dropdown.size());
		
		 for (int i = 0; i < services_dropdown.size(); i++)
		 {
			String services_drop_menu_names= services_dropdown.get(i).getText();
			System.out.println(services_drop_menu_names);
			 WebElement ele=services_dropdown.get(i);
			 String innerhtml=ele.getAttribute("innerHTML");
			 
			 if (innerhtml.contentEquals("Digital Marketing"))
			 {
				 ele.click();
				 break;
				}
			// System.out.println("THE DROP DROP VALUES ARE "+innerhtml);		
		}
		 
	    Assert.assertEquals(driver.getCurrentUrl(), "http://www.softmindinformatics.com/Digital-Marketing.html");
	    driver.close();
	}
}
