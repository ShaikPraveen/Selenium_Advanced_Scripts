package com.handling.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest 
{
//Video Link :: https://www.youtube.com/watch?v=ewUI1p-tZ64&index=41&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV
	
/*
 1. First make HUB SERVER using the below command(Go to your selenium jar file location in your local machine)
	   
    java -jar selenium-server-standalone-3.14.0.jar -role hub
	   
2. Then after you have to check HUB SERVER is Running or not using Below Command
	   
   http://localhost:4444/grid/console
	   
3. Then after we have to Register node to HUB SERVER using below command(Go to your chrome drivers location in your local machine)
	   
   E:\Praveen_Automation\Launching_Browsers\Launching_Browsers_Latest\New folder>java -Dwebdriver.chrome.driver="E:\Praveen_Automation\Launching_Browsers\Launching_Browsers_Latest\New folder\chromedriver.exe" -jar selenium-server-standalone-3.14.0.jar -role node -hub http://192.168.176.1:4444/grid/register/
	
*/
	
	
	public static WebDriver driver;
	public static String url="http://practice.automationtesting.in/my-account/";
	
	@BeforeMethod
	public void setUP() throws MalformedURLException
	{
		   String nodeURL="http://192.168.176.1:4444/wd/hub";
		   DesiredCapabilities cap=DesiredCapabilities.chrome();
		   cap.setBrowserName("chrome");
		   cap.setPlatform(Platform.WINDOWS);
		
		   // System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		   System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\geckodriver.exe");
		   
		   //driver = new ChromeDriver();
		   driver=new RemoteWebDriver(new URL(nodeURL),cap);
		   
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);	   
	}
	
	@Test
	public void loginTest()
	{
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("info.praveen77@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Praveen@786");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String captureText=driver.findElement(By.xpath("//div[contains(@class,'woocommerce-MyAccount-content')]//p[1]")).getText();
		
		if (captureText.contains("info.praveen77"))
		{
			System.out.println("TEST PASS");
			
		} else
		{
			System.out.println("TEST FAIL");
		}		
	}
	@AfterMethod
	public void tearDown()
	{
		Assert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		driver.close();
	}
}
