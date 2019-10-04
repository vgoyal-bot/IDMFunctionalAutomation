package com.idm.ui.proxyAndCertificates;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.idm.common.ConstantsSelenium;

public class HandleDeveloperModeNotificationSSLDisabilities {

    public static WebDriver disableDeveloperModeInChrome(WebDriver driver) {
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable--extensions");
        driver = new ChromeDriver(options);
        return driver;
    }

    /**
     * Disables or Hide Popup Notification in chrome
     *
     * @param driver
     * @return driver
     */
    public static WebDriver hideOrDisablePopupNotificationInChrome(WebDriver driver) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", map);
        driver = new ChromeDriver(options);
        return driver;
    }

    public static void handleSSLInFirefox() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        WebDriver driver = new FirefoxDriver(options);
        driver.get("pass the url as per your requirement");
    }

    public static void handleSSLInChrome(){
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        // Open browser with capability
        WebDriver driver=new ChromeDriver(cap);
    }

    public static void handleSSLInIE() {
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        WebDriver driver = new InternetExplorerDriver(cap);
    }

    public static void handleSSLInSafari() {
        DesiredCapabilities cap = DesiredCapabilities.safari();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        WebDriver driver = new SafariDriver(cap);
    }
}