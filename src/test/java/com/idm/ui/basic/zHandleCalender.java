package com.idm.ui.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.BrowserFactory;

/**
 * This program is to handle calender using jQuery approach. There are 2
 * approaches to handle. 1. static. 2.dynamic
 *To see more on calender, See link :
 *1. https://www.guru99.com/handling-date-time-picker-using-selenium.html
 *2. http://makeseleniumeasy.com/2017/09/18/how-to-handle-different-types-of-calendars-in-selenium-part-1/
 *
 * @author evingoy
 *
 */
public class zHandleCalender extends BaseClass {

    @Test
    public void test1() throws InterruptedException {
        WebDriver chromeDriver = BrowserFactory.getChromeDriver("http://demo.guru99.com/test/");

        String xpath = "//input[@type='datetime-local']";

        WebElement ele = chromeDriver.findElement(By.xpath(xpath));
        ele.sendKeys("09252019");

        Actions action = new Actions(chromeDriver);
        action.sendKeys(Keys.TAB).build().perform();
        ele.sendKeys("0950AM");

        chromeDriver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Test
    public void test2() {
        WebDriver chromeDriver = BrowserFactory.getChromeDriver("http://seleniumpractise.blogspot.in/2016/08/how-to-handle-calendar-in-selenium.html");

        chromeDriver.findElement(By.id("datepicker")).click();
        staticWay(chromeDriver);
        // dynamicWay(chromeDriver);
    }

    private static void staticWay(WebDriver chromeDriver) {
        // static way
        chromeDriver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[3]/a")).click();
    }

    private static void dynamicWay(WebDriver chromeDriver) {
        // dynamic way
        List<WebElement> allDates = chromeDriver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement ele : allDates) {
            String date = ele.getText();
            if (date.equalsIgnoreCase("28")) {
                ele.click();
                break;
            }
        }
    }
}