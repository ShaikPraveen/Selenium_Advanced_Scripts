package com.handling.JavascriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_Javascript_Usage
{
	//Video Link :: https://www.youtube.com/watch?v=P6LBk_qzISg&index=29&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV
	public static void main(String[] args) throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://www.twoplugs.com/");
		Assert.assertEquals(driver.getTitle(), "twoPLUGS - A plug for your Service and another for your Need");
		
		//Flashing
		WebElement join_element = driver.findElement(By.xpath("//ul[@class='control-bar']//li[2]//a[1]"));
		//Javascript_Util.flash(join_element, driver);
		
		//Drawing Border
		//Javascript_Util.drawBorder(join_element, driver);
		
		//After Drawing Border & Take Screen Shot
		//File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("E:\\Praveen_Automation\\Screenshots\\twoplugs.png"));
		
	    //Capture Title of the Page Using JavascriptExecutor
		//System.out.println(driver.getTitle()); ->Normal Method
		String title=Javascript_Util.captureTitleByJS(driver);
		System.out.println(title);
		
		
		//Click Element By Using JS
		//WebElement login_button=driver.findElement(By.xpath("//body[@class='main-template']/div[@class='wrapper']/header/div[@class='container']/ul[@class='control-bar']/li[1]/a[1]"));
		//Javascript_Util.clickElementByJS(login_button, driver);
	
		//Generate Alert at Runtime using JS
		//Javascript_Util.generateAlert(driver, "You Clicked on Login Button");
		
		//Refreshing page 
		//driver.navigate().refresh();
		//Javascript_Util.refreshpageByJS(driver);
		
		//Scroll down the page till we find the element
		//WebElement img_ele=driver.findElement(By.xpath("//img[@src='/newlayout/images/screen.png']"));
		//Javascript_Util.scrollIntoView(img_ele, driver);
		
		//Scroll the Page till end
		Javascript_Util.scrollpageDown(driver);
		
	    //driver.close();
	
	}

}
