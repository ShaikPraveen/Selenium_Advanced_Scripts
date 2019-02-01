package com.handling.WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_WebTable2
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Employee List')]")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		//COUNT NUMBER OF ROWS
		int rows=driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/form[1]/div[4]/table[1]/tbody[1]/tr")).size();
		System.out.println("NUMBER OF ROWS ARE "+rows);
	    
		//COUNT NUMBER OF COLUMNS
		int cols=driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/form[1]/div[4]/table[1]/thead[1]/tr/th")).size();
		System.out.println("NUMBE OF COLUMNS ARE "+cols);
		
		//READ ENTIRE DATA FROM WEB TABLE
		
		for (int row = 2; row <=rows; row++)
		{
			for (int col = 1; col <=cols; col++)
			{
				System.out.print(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/form[1]/div[4]/table[1]/thead[1]/tr["+row+"]/th["+col+"]")).getText()+"  ");	
			}
			System.out.println();	
		}
		
		driver.close();
	}

}
