package com.handling.Dropdown.SortedOrNot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class Handlind_DropdownSorted_OrNot
{
	//Video Link :: https://www.youtube.com/watch?v=zlknwkuIdUE&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=13
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Testing Practice");
		
		Select sele=new Select(driver.findElement(By.id("animals")));
		
		List originallist=new ArrayList<>();
		List templist = new ArrayList<>();
		
		List<WebElement> options=sele.getOptions();
		
		for(WebElement ele:options)
		{
			originallist.add(ele.getText());
			templist.add(ele.getText());
		}
		System.out.println("Before Sorting Original List "+originallist);
		System.out.println("Before Sorting Templist "+templist);
		
		//Now sorting the values using collections
		Collections.sort(templist);
		
		System.out.println("After Sorting Originallist "+originallist);
		System.out.println("After Sorting Templist "+templist);
		
		//Now compare Original List and Sorted List
		if (originallist == templist)
		{
			System.out.println("DROP DOWN SORTED");
			
		} else
		{
			System.out.println("DROP DOWN NOT SORTED");

		}
		driver.close();
	}

}
