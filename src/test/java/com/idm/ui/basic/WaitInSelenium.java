package com.idm.ui.basic;


import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;

public class WaitInSelenium {

    /**
     * In this method, it will add vinit.itm@gmail.com in the email box
     * immideately after login the page
     */
    @Test
    public void withoutImplicitWait() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.findElement(By.id("email")).sendKeys("vinit.itm@gmail.com");
    }

    /**
     * In this method, it will wait for 5 Sec then it will add password in the
     * email box after login the page
     *
     * @throws InterruptedException
     */
    @Test
    public void withNormalWait() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.findElement(By.id("email")).sendKeys("vinit.itm@gmail.com");
        driver.manage().wait(5000);
        driver.manage().notify();
        driver.findElement(By.id("pass")).sendKeys("password");
    }

    /**
     * In this method, after loading the facebook URL page, first it will enter
     * email id. Then it will maximum wait for 30 sec for the next element. if
     * the element appears then it will add password in that element, else after
     * waiting for 30 sec it will send error as NosuchElement exception.
     *
     * Note : Implicit wait for maximum duration mentioned, if the element
     * appear before that then it will move to next element. It is not same as
     * normal sleep method. In normal sleep thread sleeps for 30 sec, but here
     * it will max wait for 30 sec and if the element appear within 30 sec then
     * it will move to next element.
     *
     * Interview Question : Generally default timeout is 0
     *
     * @throws InterruptedException
     */
    @Test
    public void implicitWait() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.findElement(By.id("email")).sendKeys("vinit.itm@gmail.com");
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);

        // Here this below element will not be found even after wait for 30
        // seconds then it will throw NoSuchElement exception
        driver.findElement(By.id("pass")).sendKeys("password");
    }

    /**
     * Condition for Explicit wait in selenium webdriver
     * 
     * Condition 1- I have a web page which has some login form and after login,
     * it takes a lot of time to load Account page or Home page. This page is
     * dynamic it means sometimes it takes 10 seconds to load the homepage,
     * sometimes its 15 second and so on. In this situation, the Explicit wait
     * can help us which will wait until specific page/page title is not present
     * it will keep waiting.
     *
     * Condition 2- You are working on travel application and you have filled
     * the web form and clicked on submit button. Now you have to wait until
     * complete data is not loaded or specific data is not loaded. In this case,
     * again we can use Explicit wait in which we can give wait till specific or
     * set of elements are not loaded.
     *
     * Condition 3- There are some elements on a web page which are hidden and
     * it will be displayed only when specific conditions get true, so we have
     * to wait until these elements are not visible. In this case, again
     * explicit wait will help in which we can specify wait till the element or
     * elements are not visible.
     *
     * @throws InterruptedException
     */
    @Test
    public void explicitWait() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

        // Click on timer button to start
        driver.findElement(By.xpath(".//*[@id='post-body-7708391096228750161']/button")).click();

        // Create object of WebDriverWait class and it will wait max of 20
        // seconds.
        // By default it will accepts in Seconds
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Here we will wait until element is not visible, if element is visible
        // then it will return web element
        // or else it will throw exception
        WebElement element = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

        // if element found then we will use- In this example I just called
        // isDisplayed method
        boolean status = element.isDisplayed();

        // if else condition
        if (status) {
            System.out.println("===== WebDriver is visible======");
        } else {
            System.out.println("===== WebDriver is not visible======");
        }
    }

    /**
     * * By default explicit condition does polling every 0.5sec. and we specify the timeout- which means till what time it should does the polling.
     * This is the only difference betwen explicit and fluent wait, because in fluent wait we can explicitly mention the polling time whereas in explicit wait , it is default 0.5sec.
     */
    @Test
    public void fluentWait() {
        WebDriver driver = BrowserFactory.getFirefoxDriver(
                "http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
        driver.findElement(By.xpath(".//*[@id='post-body-7708391096228750161']/button")).click();

        FluentWait fluentWait = new FluentWait(driver);
        fluentWait.pollingEvery(1, TimeUnit.SECONDS);
        fluentWait.withTimeout(60, TimeUnit.SECONDS);

        fluentWait .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

    }

    /**
     * For detailed explanation goto link :
     * http://learn-automation.com/best-way-to-handle-synchronization-in-selenium-webdriver/
     * @throws InterruptedException
     */
    @Test
    public void customisedWaitToAvoidSyncIssues() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
        String xPath = "//button[text()='Click me to start timer']";
        driver.findElement(By.xpath(xPath)).click();
        String searchPath = "//p[text()='WebDriver']";
        WebElement element = driver.findElement(By.xpath(xPath));
        element = customizedLib(driver, searchPath, 20);
        System.out.println("is element displayed : " + element.isDisplayed());
    }

    private WebElement customizedLib(WebDriver driver, String xPath, int time) throws InterruptedException {
        WebElement element = null;
        for (int i = 0; i < time; i++) {
            try {
                element = driver.findElement(By.xpath(xPath));
                break;
            } catch (Exception e) {
                Thread.sleep(1000);
            }
        }
        return element;
    }
}
