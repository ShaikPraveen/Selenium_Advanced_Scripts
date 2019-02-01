package com.handling.compare.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Handling_Compare_Images
{
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://acegrades.com/");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		
		//Compare Image
		//First we have to Read Image in File Format
		
		BufferedImage expectedImage = ImageIO.read(new File("E:\\Praveen_Automation\\Screenshots\\acegradeslogo.png"));
		
		WebElement acelogo=	driver.findElement(By.xpath("//a[@id='logo_id']"));
		Screenshot acelogoscrrenshot=new AShot().takeScreenshot(driver,acelogo);
		
		BufferedImage actualimage = acelogoscrrenshot.getImage();
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualimage);
		
		if (diff.hasDiff()== true) 
		{
			System.out.println("IMAGES ARE NOT SAME, TEST FAIL");
		} else 
		{
			System.out.println("IMAGES ARE SAME , TEST PASS");

		}

		driver.close();
	}
}
