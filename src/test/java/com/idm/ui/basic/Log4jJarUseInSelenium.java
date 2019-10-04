package com.idm.ui.basic;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;

/**
 * we need to take care of 3 things:
 * 1. log4j jar
 * 2. log4j property file
 * 3. Configure that property file
 *
 * @author evingoy
 *
 */
public class Log4jJarUseInSelenium extends BaseClass {

    @Test
    public void test() {
        /**
         * Here we need to create logger instance so we need to pass Class name
         * for which we want to create log file in my case Google is classname
         */
        Logger logger = Logger.getLogger("Log4jJarUseInSelenium");

        // configure log4j properties file
        PropertyConfigurator.configure("log4j.properties");

        WebDriver driver = new ChromeDriver();
        logger.info("Browser Opened");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Implicit wait given");

        driver.get("https://www.google.co.in/");
        logger.info("Url opened");

        driver.findElement(By.name("q")).sendKeys("Selenium");
        logger.info("keyword type");
    }
}