package com.handling.FileDownload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadZIPFile {

	public static void main(String[] args) throws InterruptedException
	{
	
		System.setProperty("webdriver.gecko.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\Firefox_Driver\\New folder\\geckodriver.exe");
		//https://www.sitepoint.com/mime-types-complete-list/
		
		//Create Firefox Profile Object
		FirefoxProfile profile=new FirefoxProfile();
		
		//Set preference to not show file download confirmation dialogue using
		//Below Code For Text File
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		
		
		FirefoxOptions option =new FirefoxOptions();
		option.setProfile(profile);
		
		//Initialize Firefox Browser
		WebDriver driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://testingmasters.com/student-corner/downloads/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='http://testingmasters.com/wp-content/uploads/Manual-And-Selenium-FRESHERS.zip']")).click();
		
		
		
	}

}
