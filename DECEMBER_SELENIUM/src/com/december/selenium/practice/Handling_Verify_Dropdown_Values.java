package com.december.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Handling_Verify_Dropdown_Values 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		String dropdownvalues[]={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
		
		driver.get("https://www.facebook.com/");
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		
		Select sele=new Select(driver.findElement(By.xpath("//select[@id='month']")));
		List<WebElement> dropdown_value=sele.getOptions();
		System.out.println("NUMBER OF MONTH VAUES ARE "+dropdown_value.size());
		
		for (int i = 0; i < dropdown_value.size(); i++)
		{
			Assert.assertEquals(dropdownvalues[i], dropdown_value.get(i).getText());	
		}
		System.out.println("VERIFICATION SUCCESSFULL");
		driver.close();
	}
}
