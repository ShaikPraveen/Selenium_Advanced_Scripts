package com.handling.JavascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javascript_Util
{
//Video Link :: https://www.youtube.com/watch?v=P6LBk_qzISg&index=29&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV
	public static void flash(WebElement element, WebDriver driver)
	{
		//JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor"); //Green color
		for (int i = 0; i < 500; i++) //500 Times element will Blinking
		{
			changeCoLor("#000000",element,driver); // #000000 ->Black Color
			changeCoLor(bgcolor,element,driver);	
		}	
	}
	
	public static void changeCoLor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+ color +"'", element);
		
		try
		{
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
		}	
	}
	
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	public static String captureTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
		
	}

	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
    public static void generateAlert(WebDriver driver, String message)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('"+ message +"')");
    }
	
    public static void refreshpageByJS(WebDriver driver)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
    
    public static void scrollpageDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
    
    
}
