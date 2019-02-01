package com.handling.compare.images;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Handling_TakeScreenShot
{
	//Video link : https://www.youtube.com/watch?v=1CBS1AQy6zo&t=3s
	//If you want to Compare Two images, we don't have any classes and methods in selenium
	// We need to Download thirty party Api like "Ashot API(1.5.3)" and Gson(2.8.5) and Hamcrest - all(1.3)
	
	public static void main(String[] args) throws IOException
	{	
		        System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\geckodriver.exe");
				WebDriver driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				
				
				driver.get("https://acegrades.com/");
				Assert.assertEquals(driver.getTitle(), "ACEGRADES");
	
				//Steps to handle this Script
				//FirstCapture the Image and Save in FILE
				//Verify whether the Image Captured or Not
				
			WebElement acelogo=	driver.findElement(By.xpath("//a[@id='logo_id']"));
			
			Screenshot acelogoscreenshot=new AShot().takeScreenshot(driver,acelogo);
			
			ImageIO.write(acelogoscreenshot.getImage(), "png", new File("E:\\Praveen_Automation\\Screenshots\\acegradeslogo.png"));
				
			File f=new File("E:\\Praveen_Automation\\Screenshots\\acegradeslogo.png");
			
			//Verify Image is Captured or Not
			if (f.exists()) 
			{
				System.out.println("ACEGRADES LOGO IMAGE IS CAPTURED, FILE EXISTS");
				
			} else 
			{
				System.out.println("ACEGRADES LOGO IMAGE IS NOT CAPTURED, FILE DOES NOT EXISTS");	
			}	
	}

}
