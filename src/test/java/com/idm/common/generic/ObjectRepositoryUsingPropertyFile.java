package com.idm.common.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;

public class ObjectRepositoryUsingPropertyFile {

    @Test
    public void test() throws IOException {
        File file = new File("C:\\Testing\\Selenium\\utilities\\ObjectRepo.properties.txt");

        FileInputStream fis = new FileInputStream(file);
        Properties property = new Properties();
        property.load(fis);

        System.out.println("Property class loaded");

        // Open FirefoxBrowser
        WebDriver driver = BrowserFactory.getFirefoxDriver(ConstantsSelenium.FACEBOOK_URL);

        driver.findElement(By.xpath(property.getProperty("facebook.login.username.xpath")))
                .sendKeys("Selenium@gmail.com");
        driver.findElement(By.xpath(property.getProperty("facebook.login.password.xpath"))).sendKeys("adsadasdas");
        driver.findElement(By.xpath(property.getProperty("facebook.login.Signup.xpath"))).click();
    }
}
