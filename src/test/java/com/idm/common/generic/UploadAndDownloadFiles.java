package com.idm.common.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
     * Step 1- We have to copy the file location in system clipboard. Step 2- We
     * have to click on upload button and use CTR+V and ENTER. Note- Robot class
     * each key has to press and release respectively
     *
     * @throws AWTException
     * @throws InterruptedException
     */
    @Test
    public void uploadFileUsingRobotClass() throws AWTException, InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.MONSTER_URL);
        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//div[@class='bold fs-18'][contains(text(),'professional')]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//input[@id='file-upload']")));
        
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='file-upload']")).click();
        
        // Copy path to clipboard
        StringSelection sel = new StringSelection("C:\\Testing\\backup\\temprequired\\SampleUploadDocForRobot.doc");
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipBoard.setContents(sel, null);

        Robot robot = new Robot();
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
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