package com.handling.BrowserWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Switching_Windows 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//a[@href='http://www.sakinalium.in']//button[@class='btn btn-info'][contains(text(),'click')]")).click();
		//System.out.println(driver.getTitle());
		
		Set<String> windowIds = driver.getWindowHandles();
           
		for (String i : windowIds) 
		{
			//System.out.println(i);
			String Title=driver.switchTo().window(i).getTitle();
			//System.out.println(Title);
			
			//NOW I WANT TO CLOSE THE PARENT WINDOW
			
			if (Title.contains("Sakinalium | Home"))
			{
				driver.close();	
			}
		}
		
		
		//driver.quit();
	}
}
