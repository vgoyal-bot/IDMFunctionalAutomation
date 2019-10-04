package com.idm.common.generateReports;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeClass
    public void beforeClass() {
        extentReports = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
        extentTest = extentReports.startTest("Vinit Extent Report Testcases");
    }

    @Test
    public void test1() {
        System.out.println("Inside test1");
        extentTest.log(LogStatus.PASS, "Pass testcase1");
    }

    @Test
    public void test2() {
        System.out.println("Inside test2");
        extentTest.log(LogStatus.FAIL, "Fail testcase2");
    }

    @Test
    public void test3() {
        System.out.println("Inside test3");
        extentTest.log(LogStatus.ERROR, "Pass testcase3");
    }

    @Test
    public void test4() {
        System.out.println("Inside test3");
        extentTest.log(LogStatus.INFO, "Pass testcase3");
    }

    @Test
    public void test5() {
        System.out.println("Inside test3");
        extentTest.log(LogStatus.SKIP, "Pass testcase3");
    }

    @AfterTest
    public void afterClass() {
        extentReports.endTest(extentTest);
        extentReports.flush();
    }
}
