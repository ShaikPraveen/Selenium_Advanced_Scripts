package com.handling.TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1
{
	//Video Link :: https://www.youtube.com/watch?v=3l1JtRwl_yU&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=38

	@Test
	 void demoTest()
	 {
		 Assert.assertTrue(true);//PASSED
		 Assert.assertEquals("PRAVEEN", "PRAVEEN");//PASSED
		 Assert.assertEquals("SHAIK", "SHAIK");//PASSED
		 System.out.println("SUCCESSFULLY PASSED!");//PASSED
	 }
	
	
}
