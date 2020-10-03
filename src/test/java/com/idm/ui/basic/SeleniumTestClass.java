package com.idm.ui.basic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.ConstantsSelenium;

public class SeleniumTestClass extends BaseClass {

    WebDriver firefoxDriver;
    WebDriver chromeDriver;

    @BeforeClass
    public void beforeClass() {
        //        firefoxDriver = new FirefoxDriver();
        //        chromeDriver = new ChromeDriver();
    }

    @Test
    public void basicFirefoxProgWithTitle() {
        firefoxDriver.get(ConstantsSelenium.FACEBOOK_URL);
        firefoxDriver.manage().window().maximize();
        System.out.println("browser title : " + firefoxDriver.getTitle()); // To get title of page
        firefoxDriver.findElement(By.id("email")).sendKeys("vinit.itm@gmail.com");
        firefoxDriver.findElement(By.id("pass")).sendKeys("abcde");
        firefoxDriver.findElement(By.xpath(".//label[@id='loginbutton']/input[@type='submit']")).click();
    }

    @Test
    public void openDemositePageUsingFirefox() {
        firefoxDriver.get(ConstantsSelenium.DEMOSITE_URL);
        firefoxDriver.manage().window().maximize();
        firefoxDriver.findElement(By.id("user_login")).sendKeys("admin");
    }

    @Test
    public void testCheckBoxUsingFirefox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('female').click();");

        js.executeScript("document.getElementById('sing').checked=true;");
        js.executeScript("document.getElementById('code').checked=true;");

        WebElement ele = driver.findElement(By.id("female"));
        js.executeScript("arguments[0].scrollIntoView", ele);

        Thread.sleep(111111);

        driver.manage().window().maximize();


        Thread.sleep(111111);
    }

    @Test
    public void captureScreenshot() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    private void captureScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(""));
    }

}
