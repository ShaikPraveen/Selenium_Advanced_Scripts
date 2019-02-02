package com.handling.DataDrivenTesting.WithoutTestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SimpleInterest_Calculation
{
	public static void main(String[] args) throws IOException {
		
		
		
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://www.moneycontrol.com/fixed-income/calculator/fixed-deposit-calculator.html#result");
		  Assert.assertEquals(driver.getCurrentUrl(), "https://www.moneycontrol.com/fixed-income/calculator/fixed-deposit-calculator.html#result");
		  
		  FileInputStream fis=new FileInputStream("E:\\Praveen_Automation\\TestData.xlsx");
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet ws=wb.getSheet("Simple_Intereset_Calculation");
		  
		  int rc=ws.getLastRowNum();
		  System.out.println("NUMBER OF ROWS ARE "+rc);
		  
		  for (int row = 1; row<=rc; row++) 
		  {
			  XSSFRow currentrow=ws.getRow(row);
			  
			  int principle_amount=(int)currentrow.getCell(0).getNumericCellValue();//Type Casting 
			  int rateof_interest=(int)currentrow.getCell(1).getNumericCellValue();
			  int period=(int)currentrow.getCell(2).getNumericCellValue();
			  String frequency=currentrow.getCell(3).getStringCellValue();
			  int Exp_mvalue=(int)currentrow.getCell(4).getNumericCellValue();
			  
			  
			 //driver.findElement(By.id("abc")).sendKeys(12345); //Wrong
			 //driver.findElement(By.id("abc")).sendKeys(String.valueOf(12345)); //Wrong	  
			 //Note:- In Sendkeys() method will not allows Numeric Values. That' why i have used String.valueOf() Method
			 
			 driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(String.valueOf(principle_amount));
			 driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(String.valueOf(rateof_interest));
			 driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(String.valueOf(period));
			 
			 Select sele=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			 sele.selectByVisibleText("year(s)");
			 
			 Select sele1=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			 sele1.selectByVisibleText(frequency);
			 
			 driver.findElement(By.xpath("//img[@src='https://img-d02.moneycontrol.co.in/images/mf_revamp/btn_calcutate.gif']")).click();
			
			 
			 String actual_mvalue=driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
			 
			 /*
			  Note:- 1.Convert String to Integer
			           Integer.parseInt();
			         
			         2.Covert String to Double
			           Double.parseDouble(); 
			  */
			 if ((Double.parseDouble(actual_mvalue))==Exp_mvalue)
			 {
				 System.out.println("TEST PASS");
				
			} else 
			{
                System.out.println("TEST FAIL");
			}
			 
			 //driver.findElement(By.xpath("//input[@id='principal']")).clear();
			 //driver.findElement(By.xpath("//input[@id='interest']")).clear();
			 //driver.findElement(By.xpath("//input[@id='tenure']")).clear();
			 
			 
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			 
			 	
		}  
		  driver.close();
	}

}
