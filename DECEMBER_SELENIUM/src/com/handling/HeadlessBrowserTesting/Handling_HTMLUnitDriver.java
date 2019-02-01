package com.handling.HeadlessBrowserTesting;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Handling_HTMLUnitDriver 
{
	//Video URL : https://www.youtube.com/watch?v=WqIAcYXaIZA
	public static void main(String[] args)
	{
		//If you want to perform Headless browser testing using HTMLUnit DRiver, you need to download HTMLUnit Driver from Seleniumhq.org
		//Here you have to download two Jars like dependencies jars and HTMLUnit driver jar
		//Add jars to our Project
		
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("https://www.acegrades.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	    System.out.println(driver.getWindowHandle());
	
	}

}
