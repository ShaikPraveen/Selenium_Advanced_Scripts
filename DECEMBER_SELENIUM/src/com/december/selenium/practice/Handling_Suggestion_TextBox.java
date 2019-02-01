package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handling_Suggestion_TextBox 
{
	//https://stackoverflow.com/questions/38684175/how-to-click-allow-on-show-notifications-popup-using-selenium-webdriver
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		/*driver.get("https://www.cleartrip.com");
		driver.findElement(By.xpath("//input[@id='FromTag']")).clear();
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("hyd");
		driver.findElement(By.xpath("//input[@id='FromTag']")).click();
		
		List<WebElement> totalcities=driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li/a[1]"));
		System.out.println("TOTAL NUMBER OF CITIES ARE "+totalcities.size());
		
		for(int i=0; i < totalcities.size();i++)
		{
			String citinames=totalcities.get(i).getText();
			System.out.println("CITY NAMES ARE "+citinames);
		}	
*/

		
		driver.get("https://apsrtconline.in/oprs-web/");
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).clear();
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("ban");
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).click();
		
		List<WebElement> totalcities=driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li/a[1]"));
		System.out.println("TOTAL NUMBER OF CITIES ARE "+totalcities.size());
		
		for(int i=0; i < totalcities.size();i++)
		{
			String citinames=totalcities.get(i).getText();
			System.out.println("CITY NAMES ARE "+citinames);	
		}
		
		driver.close();
	}
}
