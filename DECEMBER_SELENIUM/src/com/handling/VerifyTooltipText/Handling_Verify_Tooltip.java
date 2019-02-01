package com.handling.VerifyTooltipText;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Verify_Tooltip 
{
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.acegrades.com");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		driver.findElement(By.linkText("LOG IN")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sample@teacher.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='loginId']")).click();
		
		//Verify CLASSES Link is Displayed or not in Teacher Dashboard
		/*WebElement classestext = driver.findElement(By.xpath("//a[@ui-sref='teacher_classes']"));
		Assert.assertEquals(classestext,"CLASSES");
		*/
		String tooltipText=driver.findElement(By.xpath("//a[@title='Assignments']")).getAttribute("title");
	    System.out.println("TOOTIP TEXT IS "+tooltipText);
		Assert.assertEquals(tooltipText, "Assignments");
	    driver.close();
	}

}
