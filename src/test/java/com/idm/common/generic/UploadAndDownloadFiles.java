package com.idm.common.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import com.idm.common.ConstantsSelenium;

public class UploadAndDownloadFiles {

    static {
        // to know about the below lines: what they do check static block of
        // LearnSeleniumBaseClass.java
        System.setProperty(ConstantsSelenium.GECKO_DRIVER_PROP1, ConstantsSelenium.GECKO_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.IE_DRIVER_PROP, ConstantsSelenium.IE_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.ME_DRIVER_PROP, ConstantsSelenium.ME_DRIVER_PATH);
    }

    /**
     * Remember following thing when uploading files in WebDriver
     *
     * There is no need to simulate the clicking of the "Browse" button.
     * WebDriver automatically enters the file path onto the file-selection text
     * box of the <input type="file"> element
     */
    @Test
    public void uploadFileWithoutAutoITWithoutRobotClass() {
        String baseUrl = "http://demo.guru99.com/selenium/upload/";
        WebDriver driver = new ChromeDriver();

        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys(ConstantsSelenium.UPLOAD_FILE_URL);

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();

    }

    /**
     * WebDriver has no capability to access the Download dialog boxes presented
     * by browsers when you click on a download link or button. However, we can
     * bypass these dialog boxes using a separate program called "wget"
     *
     * Wget is a small and easy-to-use command-line program used to automate
     * downloads. Goto link for further study :
     * https://www.guru99.com/upload-download-file-selenium-webdriver.html
     */
    @Test
    public void downloadFileUsingWGet() {
    }

    /**
     *
     * @param fileURL
     *            : Url from where to download the file
     * @param xpath
     *            : xpath of element to click to download the file
     */
    public static void downloadFiles(String fileURL, String xpath) {

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // fileURL = "http://www.filehippo.com/download_adobe_reader";
        driver.get(fileURL);

        // xpath = ".//*[@id='program-header']/div[4]/a[1]";
        driver.findElement(By.xpath(xpath)).click();
    }
}