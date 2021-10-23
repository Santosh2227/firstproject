package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersEx implements ITestListener {

	public Logger log=Logger.getLogger(ListenersEx.class);

	public void onTestStart(ITestResult result) {
		log.info("Test Case Starts With Name :"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test Case Passed With Name :"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		log.info("Test Case Failured With Name :"+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		log.info("Test Case Skipped With Name :"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		log.info("Test Suite Is Ready To Start The execution");

	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Is finished To Start The execution");

	}

}
