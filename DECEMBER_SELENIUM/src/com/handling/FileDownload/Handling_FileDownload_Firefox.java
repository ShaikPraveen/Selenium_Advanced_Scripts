package com.handling.FileDownload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

public class Handling_FileDownload_Firefox
{
	//Video Link :: https://www.youtube.com/watch?v=LCp4uGXy5gg&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=19
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\Firefox_Driver\\New folder\\geckodriver.exe");
		//https://www.sitepoint.com/mime-types-complete-list/
		
		//Create Firefox Profile Object
		FirefoxProfile profile=new FirefoxProfile();
		
		//Set preference to not show file download confirmation dialogue using
		//Below Code For Text File
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		
		
		FirefoxOptions option =new FirefoxOptions();
		option.setProfile(profile);
		
		//Initialize Firefox Browser
		WebDriver driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		Assert.assertEquals(driver.getTitle(), "File input - Multi select");
		
		//DOWNLOAD TEXT FILE
		driver.findElement(By.id("textbox")).sendKeys("demo@teacher.com");
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
		
		
		/*//DOWNLOAD PDF FILE
		driver.findElement(By.id("pdfbox")).sendKeys("demo@teacher.com");
		driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();	
*/	}
}
