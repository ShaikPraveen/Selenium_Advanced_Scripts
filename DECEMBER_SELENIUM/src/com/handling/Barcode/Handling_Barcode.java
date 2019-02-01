package com.handling.Barcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Handling_Barcode
{
	public static void main(String[] args) throws IOException, NotFoundException
	{
	//What is Bar Code?
	// Bar code is Machine readable optical and label and that contains information about the item to which it is attached
		
	//If you want to Automate the Bar code, You need to Download the ZXing API from google
    //Here we have to download Two Jar files like ZXing API(3.3.3) and ZXing Java SE Extensions(3.3.3)
	
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Testing Practice");
	    
		//First Barcode
		//String barcodeURL = driver.findElement(By.xpath("//img[@src='https://3.bp.blogspot.com/-xaeByLfXiFk/XCxZ33hrgKI/AAAAAAAAPPI/5d4O-mf27lEQKtSiiBjx3UgtxSV0yJUpwCLcBGAs/s1600/barcode.gif']")).getAttribute("src");
		//System.out.println(barcodeURL);
		
		
		//Second Barcode
		String barcodeURL = driver.findElement(By.xpath("//img[@src='https://4.bp.blogspot.com/-_Bz0eHUicUY/XCxnkToPvQI/AAAAAAAAPPU/055m3a6VabUzUlwlzwwipQA-MImBuxq_wCLcBGAs/s1600/barcode2.gif']")).getAttribute("src");
		
	    
	    URL url = new URL(barcodeURL);
	    BufferedImage bufferedimage=ImageIO.read(url);
	    
	    LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimage);
	    
	    BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
	    
	    Result result = new MultiFormatReader().decode(binarybitmap);
	    System.out.println(result.getText());
	    
	    driver.close();
	    
	    //Sample Barcode URL 
	    //https://barcode.tec-it.com/en
	}
}
