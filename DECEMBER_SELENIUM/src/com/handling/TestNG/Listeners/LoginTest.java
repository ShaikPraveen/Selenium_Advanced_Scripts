package com.handling.TestNG.Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest
{
	//Video Link :: https://www.youtube.com/watch?v=2yNo9Q2Tn70&index=40&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV
	
	@Test
	public void loginByEmail()
	{
		System.out.println("LOGIN BY EMAIL");
		Assert.assertEquals("PRAVEEN", "PRAVEEN");
	}
	
	@Test
	public void loginByFacebook()
	{
		System.out.println("LOGIN BY FACEBOOK");
		Assert.assertEquals("shaik123","shaik");	
	}

}
