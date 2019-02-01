package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Count_Total_Frames
{
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_button_formtarget");
		Assert.assertEquals(driver.getTitle(), "Tryit Editor v3.6");
		
		/*driver.findElement(By.xpath("//input[@class='form-control' and @name='username']")).sendKeys("Praveen1177");
		driver.findElement(By.xpath("//input[@class='form-control' and @name='password']")).sendKeys("praveen@1120");
		driver.findElement(By.xpath("//input[@class='btn btn-small' and @type='submit']")).click();
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		*/
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> totalframes=driver.findElements(By.tagName("iframe"));
		System.out.println(totalframes.size());
		for(WebElement ele :totalframes)
		{
			  System.out.println("Frame Id   "+ele.getAttribute("id"));
			  System.out.println("Frame Nmae "+ele.getAttribute("name"));	
		}	
		}
}
