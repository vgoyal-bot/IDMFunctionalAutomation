package com.idm.ui.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;

/**
 * Please check the doc to get thec omplete knowledge
 * @author evingoy
 *
 */
public class XPath {

    @Test
    public void openFacebookPageInChrome() {
        WebDriver driver = BrowserFactory.getChromeDriver(ConstantsSelenium.FACEBOOK_URL);
        String xPath1 = ".//input[@id='u_0_j']";
        String xPath2 = ".//*[@id='u_0_l']";
        String xPath3 = ".//*[text()='u_0_o']";
        driver.findElement(By.xpath(xPath1)).sendKeys("Vinit");
        driver.findElement(By.xpath(xPath2)).sendKeys("Goyal");
        driver.findElement(By.xpath(xPath3)).sendKeys("vinit.itm");

    }

    @Test
    public void openGuru99Page() {
        WebDriver driver = BrowserFactory.getChromeDriver("http://demo.guru99.com/v1/");
        String xPath1 = ".//input[@name='uid']";
        String xPath2 = ".//*[@type='password']";
        String xPath3 = ".//input[@value='LOGIN']";
        driver.findElement(By.xpath(xPath1)).sendKeys("Vinit");
        driver.findElement(By.xpath(xPath2)).sendKeys("Goyal");
        driver.findElement(By.xpath(xPath3)).click();
    }

    /**
     * contains tag xpath = ".//tag[@contains(@field,value)]"
     */
    @Test
    public void openGuru99PageUsingContainsMethod() {
        WebDriver driver = BrowserFactory.getChromeDriver("http://demo.guru99.com/v1/");
        String xPath1 = ".//input[contains(@name,'uid')]";
        String xPath2 = ".//*[contains(@type,'pass')]";
        String xPath3 = ".//a[contains(@href,'http://demo.guru99.com/')]";
        driver.findElement(By.xpath(xPath1)).sendKeys("Vinit");
        driver.findElement(By.xpath(xPath2)).sendKeys("Goyal");
        driver.findElement(By.xpath(xPath3)).click();
    }

    // Using AND OR operator
    @Test
    public void openGuru99PageUsingOperators() {
        WebDriver driver = BrowserFactory.getChromeDriver("http://demo.guru99.com/v1/");
        String xPath1 = "//input[@name='uid' AND @type='text']";
        String xPath2 = ".//*[@name='password' OR @type='password']";
        String xPath3 = ".//a[contains(@href,'http://demo.guru99.com/')]";
        driver.findElement(By.xpath(xPath1)).sendKeys("Vinit");
        driver.findElement(By.xpath(xPath2)).sendKeys("Goyal");
        driver.findElement(By.xpath(xPath3)).click();
    }

    // Using text () Function
    @Test
    public void openGuru99PageUsingStartWithFunc() {
        WebDriver driver = BrowserFactory.getChromeDriver("http://demo.guru99.com/v1/");
        String xPath1 = ".//*[text()='UserID']";
        System.out.println("input tag : " + driver.findElement(By.xpath(xPath1)).getTagName());
    }
}