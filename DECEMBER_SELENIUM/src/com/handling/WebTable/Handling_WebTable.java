package com.handling.WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_WebTable 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/Manohar/Desktop/Webtable.html");
		
		//1.COUNT NUMBER OF ROWS 
		int rows=driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
		System.out.println("NUMBER OF ROWS ARE "+rows);
		
		//2.COUNT NUMBER OF COLUMNS
		int cols=driver.findElements(By.xpath("html/body/table/tbody/tr/th")).size();
		System.out.println("NUMBER OF COLUMNS ARE "+cols);
		
		//3. READ ENTIRE DATA FROM TABLE
		
		   for (int row = 2; row <=rows;row++)
		   {

			   for (int col=1; col<=cols;col++)
			   {
                  System.out.print(driver.findElement(By.xpath("html/body/table/tbody/tr["+row+"]/td["+col+"]")).getText()+"  ");
			   }
			   System.out.println();
				
			}
		   driver.close();	
	     }	
	}


