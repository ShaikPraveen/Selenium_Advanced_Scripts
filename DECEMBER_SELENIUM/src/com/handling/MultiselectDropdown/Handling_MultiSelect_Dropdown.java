package com.handling.MultiselectDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Handling_MultiSelect_Dropdown 
{
	//Video Link :: https://www.youtube.com/watch?v=t9EcrpdAT0E
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
	   
		driver.switchTo().frame("iframeResult");
		Select sele=new Select(driver.findElement(By.xpath("//select[@name='cars']")));
		sele.selectByIndex(0);
		sele.selectByValue("opel");
		sele.selectByVisibleText("Audi");
		
		Thread.sleep(2000);
		//sele.deselectAll(); //It will de-select all values in drop down
		sele.deselectByIndex(0);
		
		//Now i want to show remaining selected values
		List<WebElement> selectedvlues= sele.getAllSelectedOptions();
		System.out.println("SELECTED VALUES ARE "+selectedvlues.size());
		
		//Now i want print selected Values in Drop Down
		for(WebElement selectedcars : selectedvlues)
		{
			System.out.println("SELECTED CARS "+selectedcars.getText());
			System.out.println("================");
		}
		
		//Now i want to see all values in Drop down
		List<WebElement> allcars=sele.getOptions();
		for(WebElement allcarnames : allcars)
		{
			System.out.println("ALL CARS PRESENT IN CARS DROP DOWN "+allcarnames.getText());
			
		}
		driver.close();	
	}

}
