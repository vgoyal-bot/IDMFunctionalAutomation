package com.idm.common;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getFirefoxDriver(String url) {
        // set Gecko driver path required for selenium 3 and to run in firefox
        System.setProperty(ConstantsSelenium.GECKO_DRIVER_PROP, ConstantsSelenium.GECKO_DRIVER_PATH);
        // if above property does not work then use the below one
        // System.setProperty("webdriver.firefox.marionette",ConstantsSelenium.GECKO_DRIVER_PATH);

        if (url == null) {
            return new FirefoxDriver();
        }
        driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }

    public static WebDriver getChromeDriver(String url) {
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    public static WebDriver getIEDriver(String url) {
        System.setProperty(ConstantsSelenium.IE_DRIVER_PROP, ConstantsSelenium.IE_DRIVER_PATH);
        driver = new InternetExplorerDriver();
        driver.get(url);
        return driver;
    }

    public static WebDriver getMEDriver(String url) {
        System.setProperty(ConstantsSelenium.ME_DRIVER_PROP, ConstantsSelenium.ME_DRIVER_PATH);
        driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }

    public static WebDriver getChromeDriverWithDisabledChromeNotifications(String url) {

        Map<String, Object> prefs = new HashMap<String, Object>();

        // Set the notification setting it will override the default setting
        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);

        driver = new ChromeDriver(options);
        driver.get(url);

        return driver;
    }
}