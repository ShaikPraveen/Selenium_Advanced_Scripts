package com.handling.DataDrivenTesting.WithoutTestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Newtours_RegistrationTest
{
	public static void main(String[] args) throws IOException
	{
		  System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("http://www.newtours.demoaut.com/");
		  Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
		  
		  FileInputStream fis=new FileInputStream("E:\\Praveen_Automation\\TestData.xlsx");
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet ws=wb.getSheet("Newtours_Registration");
		  
		  int rc=ws.getLastRowNum();
		  System.out.println("NUMBER OF ROWS ARE "+rc);
		  
		  for (int row = 1; row<=rc; row++)
		  {
			 XSSFRow currentrow= ws.getRow(row);
			 
			 String first_name=currentrow.getCell(0).getStringCellValue();
			 String last_name=currentrow.getCell(1).getStringCellValue();
			 String phone=currentrow.getCell(2).toString();
			 String email=currentrow.getCell(3).getStringCellValue();
			 String address=currentrow.getCell(4).getStringCellValue();
			 String city=currentrow.getCell(5).getStringCellValue();
			 String state=currentrow.getCell(6).getStringCellValue();
			 String postal_code=currentrow.getCell(7).toString();
			 String county=currentrow.getCell(8).getStringCellValue();
			 String user_name=currentrow.getCell(9).getStringCellValue();
			 String user_password=currentrow.getCell(10).getStringCellValue();
			 String user_confirm_password=currentrow.getCell(11).getStringCellValue();
			 
			 driver.findElement(By.linkText("REGISTER")).click();
			 
			 //Contact Information
			 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(first_name);
			 driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(last_name);
			 driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
			 driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(email);
			 
			 //Mailing Information
			 driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
			 driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
			 driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
			 driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(postal_code);
			 
			 Select sele=new Select(driver.findElement(By.xpath("//select[@name='country']")));
			        sele.selectByVisibleText(county);
			 
			 //User Information
			 driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user_name);
			 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(user_password);
			 driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(user_confirm_password);
			 
			driver.findElement(By.xpath("//input[@name='register']")).click();
			
			if (driver.getPageSource().contains("Thank you for registering"))
			{
				System.out.println("Registration Complted for "+ row +" Record");
				
			} else 
			{
				System.out.println("Registration Failed "+row +" Record");
			}	
		}
		  driver.close();
		  fis.close();
	}

}
