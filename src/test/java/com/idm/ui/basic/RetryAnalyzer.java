package com.idm.ui.basic;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;

public class RetryAnalyzer implements IRetryAnalyzer {

    int minRetryCount = 0;

    // set maxcounter value this will execute our test 3 times
    int maxRetryCount = 2;

    public boolean retry(ITestResult result) {
        if (minRetryCount <= maxRetryCount) {
            System.out.println("Following test is failing====" + result.getName());
            System.out.println("Retrying the test Count is=== " + (minRetryCount + 1));

            minRetryCount++;
            return true;
        }
        return false;
    }
}

/**
 * Here we have to specify the class In our case class name is
 * RetryorRerunFailedTestCases
 * @author evingoy
 */
class VerifyTitle
{
    @Test(retryAnalyzer=RetryAnalyzer.class)
    public void verifySeleniumTitle()
    {
       Assert.assertEquals(10, 11);
    }
}