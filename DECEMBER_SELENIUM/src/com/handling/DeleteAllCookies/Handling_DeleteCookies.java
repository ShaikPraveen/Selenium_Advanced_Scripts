package com.handling.DeleteAllCookies;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.cookie.ClientCookie;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_DeleteCookies 
{
	//Video Link ::  https://www.youtube.com/watch?v=yQMjIpMVyTw
	public static void main(String[] args)
	{
		//What is Cookie?
		//Cookies are generally as Temporary Files
		//Session Cookies and Persistent Cookies
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.acegrades.com");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		Set<Cookie>  allcookies=driver.manage().getCookies();
		System.out.println("NUMBER OF COOKIES ARE =>"+allcookies.size());
		
		for(Cookie cokie : allcookies)
		{
			System.out.println("NAME   = "+cokie.getName());
			System.out.println("DOMAIN = "+cokie.getDomain());
			System.out.println("PATH   = "+cokie.getPath());
			System.out.println("VALUE  = "+cokie.getValue());
			System.out.println("========================");
		}
		driver.manage().deleteAllCookies();
		Set<Cookie> afterdeletecookies=driver.manage().getCookies();
		System.out.println("AFTER DELETE ALL COOKIES =>"+afterdeletecookies.size());
		
		driver.close();
		
	}
}
