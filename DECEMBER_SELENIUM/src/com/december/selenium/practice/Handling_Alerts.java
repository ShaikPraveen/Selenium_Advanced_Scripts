package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

public class Handling_Alerts
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.navigate().to("http://primusbank.qedgetech.com");
		Assert.assertEquals(driver.getTitle(), "Primus BANK");
		
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://primusbank.qedgetech.com/adminflow.aspx");
		
		driver.findElement(By.xpath("//table/tbody/tr[8]/td/a/img")).click();
		//Assert.assertEquals(driver.getCurrentUrl(), "primusbank.qedgetech.com/Admin_Emp_details.aspx");
		
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[7]/a/img")).click();
		
		Alert alt=driver.switchTo().alert();
		String alt_text=alt.getText();
		System.out.println("ALERT TEXT IS "+alt_text);
		
		alt.dismiss();
		
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[7]/a/img")).click();
        alt.accept();		
		driver.close();
	}
}
