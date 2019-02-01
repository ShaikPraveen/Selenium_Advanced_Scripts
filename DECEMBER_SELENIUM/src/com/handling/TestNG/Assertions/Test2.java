package com.handling.TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2
{

	@Test
	 void demoTest()
	 {
		 Assert.assertTrue(true);//PASSED
		 Assert.assertEquals("PRAVEEN", "pRAVEEN");//Failed
		 Assert.assertEquals("SHAIK", "SHAIK");// will not execute this statement
		 System.out.println("SUCCESSFULLY PASSED!");
	 }

}
