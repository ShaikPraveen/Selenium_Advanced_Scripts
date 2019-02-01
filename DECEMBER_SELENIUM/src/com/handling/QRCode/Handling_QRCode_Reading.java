package com.handling.QRCode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Handling_QRCode_Reading 
{
	public static void main(String[] args) throws IOException, NotFoundException
	{
		//What is QR Code?
		//Actually QR Code consists of Black Space arranged in Square with white spaces
		//To handle QR Code we will use Thirty party tool like ZXing API
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Testing Practice");
	   
		String qrcodeURL = driver.findElement(By.xpath("//img[@src='https://2.bp.blogspot.com/-pvlE2uQU6Jg/XCx2wNhWs8I/AAAAAAAAPPs/upCq39nWswU839wODhr6xtimoukMzEPBQCLcBGAs/s1600/qrcode.png']")).getAttribute("src");

		URL url = new URL(qrcodeURL);
		BufferedImage bufferedimage = ImageIO.read(url);
		LuminanceSource luminancesource= new BufferedImageLuminanceSource(bufferedimage);
		
		BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
		
		Result result =  new MultiFormatReader().decode(binarybitmap);
		System.out.println(result.getText());
		
		driver.close();
		
		//Sample QR Code URL
		//https://www.the-qrcode-generator.com/
	}
}
