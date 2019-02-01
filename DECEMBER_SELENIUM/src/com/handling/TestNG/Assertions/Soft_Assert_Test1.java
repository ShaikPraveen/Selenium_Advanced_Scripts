package com.handling.TestNG.Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert_Test1
{
	
	SoftAssert softassert1=new SoftAssert();
	SoftAssert softassert2=new SoftAssert();
	
	
	
	@Test
	public void softAssertTest()
	{
		softassert1.assertEquals("PRAVEEN", "praVEEN"); 
		softassert1.assertAll();
	}

	@Test
	public void softAssertTest1()
	{
		softassert2.assertEquals("shaik", "shaik"); 
		softassert2.assertAll();
	}
}
