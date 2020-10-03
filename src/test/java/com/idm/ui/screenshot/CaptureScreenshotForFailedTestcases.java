package com.idm.ui.screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;

public class CaptureScreenshotForFailedTestcases {

    WebDriver driver;

    @Test
    public void captureScreenshot() throws Exception {
        driver = BrowserFactory.getFirefoxDriver(ConstantsSelenium.FACEBOOK_URL);

        // Here we are forcefully passing wrong id so that it will fail our testcase
        driver.findElement(By.xpath(".//*[@id='emailasdasdas']")).sendKeys("Learn Automation");
    }

    // It will execute after every test execution
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("C:/selenium/" + result.getName() + ".png"));
                System.out.println("Screenshot taken");

            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        driver.quit();
    }
}