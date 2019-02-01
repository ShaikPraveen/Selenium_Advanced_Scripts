package com.handling.DatePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_DatePicker1 
{
	//Video URL :: https://www.youtube.com/watch?v=uzvQJrplZB8
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://www.expedia.co.in/");
		Assert.assertEquals(driver.getTitle(), "Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares");
		
		driver.findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']")).click();
		Thread.sleep(3000);
		
		String month ="Jun 2019";
		String exp_day="1";
		
		//String text=driver.findElement(By.xpath("//caption")).getText();
		//System.out.println(text); //Jan 2019
		
		while(true)
		{
			String text=driver.findElement(By.xpath("//caption")).getText();
			
			if (text.equals(month))
			{
				break;
				
			} else
			{
				driver.findElement(By.xpath("//div[@class='datepicker-cal']//button[2]")).click();
			}
		}
		
		 List<WebElement> alldates = driver.findElements(By.xpath("//div[@class='datepicker-cal']//div[2]//table[1]//tbody[1]//tr//td//button[1]"));
	    
	     for(WebElement ele : alldates)
	     {
	    	 String datestext=ele.getText(); //it contains two values like month and date, 
	         //Now we have to separate month and date using Split() method
	    	 String dates[]=datestext.split("\n"); // This is the regular expression,Wherever the next line appears we will use Split
	    	 if(dates[1].equals(exp_day))
	    	 {
	    		 ele.click();
	    		 break;
	    	 }
	     }
	}

}
