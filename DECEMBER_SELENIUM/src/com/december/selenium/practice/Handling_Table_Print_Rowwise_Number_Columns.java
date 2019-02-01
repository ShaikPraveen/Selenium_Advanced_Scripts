package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Table_Print_Rowwise_Number_Columns
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://primusbank.qedgetech.com");
		Assert.assertEquals(driver.getTitle(), "Primus BANK");
		
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://primusbank.qedgetech.com/adminflow.aspx");
		
		driver.findElement(By.xpath("//table/tbody/tr[8]/td/a/img")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://primusbank.qedgetech.com/Admin_Emp_details.aspx");
		
		WebElement table=driver.findElement(By.xpath("//table[@id='DGBanker']"));
		List<WebElement> rows,clos;
		
		rows=driver.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size()-1; i++)
		{
			clos=rows.get(1).findElements(By.tagName("td"));
			System.out.println("ROW NO: "+ i + " NUMBER OF COLUMNS: "+clos.size());		
		}
		
		driver.findElement(By.xpath("//table/tbody/tr/td[3]/table/tbody/tr/td[3]/a/img")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://primusbank.qedgetech.com/");
		driver.close();
	}
}
