package com.handling.PracticalExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Footer_Links
{
	public static void main(String[] args)
	{
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://www.acegrades.com");
		  Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		  
		  //Count  Number of Links
		  System.out.println("TOTAL LINKS IN THE PAGE");
		  System.out.println(driver.findElements(By.tagName("a")).size());
		  
		  //Count Footer Links  
		  WebElement footer=driver.findElement(By.xpath("//section[@id='contact']//div[@class='container']"));
		  System.out.println("TOTAL FOOTER LINKS ARE");
		  System.out.println(footer.findElements(By.tagName("a")).size());
		  
		 //Count About Links Only  
		 WebElement about_links= driver.findElement(By.xpath("//div[@class='col-md-3 text-center']"));
		 System.out.println("NUMBER OF LINKS IN ABOUT IS");
		 System.out.println(about_links.findElements(By.tagName("a")).size());
		 
		 for (int i = 0; i < about_links.findElements(By.tagName("a")).size(); i++)
		 {
			 System.out.println(about_links.findElements(By.tagName("a")).get(i).getText());	 
		
                if (about_links.findElements(By.tagName("a")).get(i).getText().contains("Awards"))
                {
                	about_links.findElements(By.tagName("a")).get(i).click();
                	break;
				}		 
		 }
		 
		 WebElement awards_text=driver.findElement(By.xpath("//u[contains(text(),'ACEGRADES AWARDS')]"));
		 Assert.assertTrue(awards_text.isDisplayed());
		 
		 Assert.assertEquals(driver.getTitle(), "Acegrades Awards");
		 System.out.println("=================");
		 driver.close();	
	}
}
