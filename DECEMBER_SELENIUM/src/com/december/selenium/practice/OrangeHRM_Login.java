package com.december.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class OrangeHRM_Login 
{
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Praveen_Automation\\Selenium_Latest\\Gecko_Driver\\geckodriver.exe");
	    WebDriver driver=new FirefoxDriver();
				 
	    //System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Selenium_Latest\\chromedriver.exe");
	    //WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    
	    
	    driver.get("http://orangehrm.qedgetech.com/");
	    String pageTitle=driver.getTitle();
	    System.out.println("TITLE OF THE PAGE "+pageTitle);
	    Assert.assertEquals(pageTitle, "OrangeHRM");
	    
	    driver.findElement(By.xpath("//input[@id='txtUsername' and @name='txtUsername']")).sendKeys("Admin");
	    driver.findElement(By.xpath("//input[@id='txtPassword' and @name='txtPassword']")).sendKeys("Admin");
	    driver.findElement(By.xpath("//input[@id='btnLogin' and @type='submit' and @value='LOGIN']")).click();
	    String pageURL=driver.getCurrentUrl();
	    System.out.println("CURRENT URL OF THE PAGE "+pageURL);
	    Assert.assertEquals(pageURL, "http://orangehrm.qedgetech.com/symfony/web/index.php/dashboard");
	    
	    driver.findElement(By.linkText("PIM")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Add Employee")).click();
	    
	    String empID=driver.findElement(By.xpath("//input[@id='employeeId' and @name='employeeId']")).getAttribute("value");
	    System.out.println("EMPLOYEE ID IS "+empID);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='welcome']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[3]/a")).click();
	    driver.close();    
	}

}
