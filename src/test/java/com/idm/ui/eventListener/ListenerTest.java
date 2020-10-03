package com.idm.ui.eventListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{
  /**
   * 
   */

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("vinit The name of the testcase start is :"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("vinit The name of the testcase success is :"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("vinit The name of the testcase failure is :"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("vinit The name of the testcase Skipped is :"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
