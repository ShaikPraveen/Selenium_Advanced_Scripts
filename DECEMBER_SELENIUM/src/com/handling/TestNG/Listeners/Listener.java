package com.handling.TestNG.Listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter
{
	public void onTestStart(ITestResult tr)
	{
		System.out.println("TEST STARTED");
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("TEST PASSED");
	}
	
	public void onTestFailure(ITestResult tr)
	{
		System.out.println("TEST FAILED");
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("TEST SKIPPED");
	}

}
