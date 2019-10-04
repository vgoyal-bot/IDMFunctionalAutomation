package com.idm.ui.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;

public class CaptureScreenshotFullProg {

    @Test
    public void TestJavaS1() {
        WebDriver driver = BrowserFactory.getFirefoxDriver(ConstantsSelenium.FACEBOOK_URL);

        CaptureScreenshotFullProg.captureScreenShot(driver);

        // Maximize the window
        driver.manage().window().maximize();
        CaptureScreenshotFullProg.captureScreenShot(driver);

        // Pass the url
        driver.get("http://www.google.com");
        CaptureScreenshotFullProg.captureScreenShot(driver);
    }

    public static void captureScreenShot(WebDriver ldriver) {
        // Take screenshot and store as a file format
        TakesScreenshot ts = (TakesScreenshot) ldriver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src,
                    new File("C:\\Testing\\Selenium\\utilities\\screenshots\\" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}