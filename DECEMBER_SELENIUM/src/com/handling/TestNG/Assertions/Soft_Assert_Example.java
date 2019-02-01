package com.handling.TestNG.Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert_Example
{
	SoftAssert softassert=new SoftAssert();
	
	
	@Test
	public void softAssertTest()
	{
		softassert.assertTrue(true); //Passed
		softassert.assertEquals("PRAVEEN", "pRAVEEN");//Failed
		softassert.assertEquals("shaik", "shaik");//Passed
		System.out.println("SUCCESSFULLY PASSED!");
		softassert.assertAll();
	}

}
