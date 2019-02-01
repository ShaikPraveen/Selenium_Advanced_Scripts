package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Tables_Count_Columns 
{
	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://money.rediff.com/tools/forex");
		Assert.assertEquals(driver.getTitle(), "Forex and Currency Converter : BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks");
		
		WebElement table=driver.findElement(By.xpath("//table[@class='dataTable']"));
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		System.out.println("NUMBER OF ROWS ARE "+rows.size());
		List<WebElement> clos=rows.get(1).findElements(By.tagName("td"));
		System.out.println("NUMBER OF COLUMNS ARE "+clos.size());
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://money.rediff.com/tools/forex");
		driver.close();
	}
}
