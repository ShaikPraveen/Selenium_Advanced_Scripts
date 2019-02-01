package com.handling.TestNG.Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert_Test
{
	
	SoftAssert softassert=new SoftAssert();
	
	
	@Test
	public void softAssertTest()
	{
		softassert.assertEquals("PRAVEEN", "praVEEN"); //// THIS IS FAILED TEST CASE
		softassert.assertAll();
	}

	@Test
	public void softAssertTest1()
	{
		softassert.assertEquals("shaik", "shaik"); // THIS IS PASSED TEST CASE
		softassert.assertAll();
	}

	//NOTE : WHEN YOU RUN THIS TEST CASE, IT WILL FAIL BOTH TEST CAESS. WHY BECAUSE HERE SAME OBJECT NAME WE HAVE USED.
	//TO OVERCOME THIS PROBLEM WE USE DIFFERENT OBJECT NAMES
	
	
}
