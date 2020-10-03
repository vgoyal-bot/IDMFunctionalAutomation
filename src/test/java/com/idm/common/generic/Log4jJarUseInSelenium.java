package com.idm.common.generic;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.idm.common.BrowserFactory;

/**
 * we need to take care of 3 things:
 * 1. log4j jar
 * 2. log4j property file
 * 3. Configure that property file
 *
 * @author evingoy
 *
 */
public class Log4jJarUseInSelenium {

    public static void main(String[] args) {
        /**
         * Here we need to create logger instance so we need to pass Class name
         * for which we want to create log file in my case Google is classname
         */
        Logger logger = Logger.getLogger("Log4jJarUseInSelenium");

        // configure log4j properties file
        PropertyConfigurator.configure("log4j.properties");
        
        WebDriver driver = BrowserFactory.getFirefoxDriver(null);
        logger.info("Browser Opened");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Implicit wait given");

        driver.get("https://www.google.co.in/");
        logger.info("Url opened");

        driver.findElement(By.name("q")).sendKeys("Selenium");
        logger.info("keyword type");
    }
}