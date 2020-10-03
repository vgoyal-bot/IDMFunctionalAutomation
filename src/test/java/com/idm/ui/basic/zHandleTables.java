package com.idm.ui.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.BrowserFactory;


/**
 * To study more about tables :
 * use below link :
 * 1. https://www.guru99.com/handling-dynamic-selenium-webdriver.html
 * 2. https://www.softwaretestinghelp.com/selenium-tutorial-18/
 * 3. https://www.toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/
 * 4. https://www.softwaretestinghelp.com/selenium-tutorial-18/
 * 5. Nested Table : https://www.guru99.com/selenium-webtable.html
 * @author vinitg
 *
 */
public class zHandleTables extends BaseClass {

    /**
     * To count the number of rows and columns in a table using first approach.
     */
    @Test
    public void firstway() {
        WebDriver chromeDriver = BrowserFactory.getChromeDriver("http://toolsqa.com/automation-practice-table/");

        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String xpathRow = ".//table[@summary='Sample Table']/tbody/tr";
        List<WebElement> eleList = chromeDriver.findElements(By.xpath(xpathRow));
        System.out.println("Number of rows: " + eleList.size());

        String xpathCol = ".//table[@summary='Sample Table']/thead/tr[1]/th";
        eleList = chromeDriver.findElements(By.xpath(xpathCol));
        System.out.println("Number of Columns: " + eleList.size());
        
        List<Integer> list = new ArrayList<Integer>();
    }

    @Test
    public void test() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/test/table.html");

        int numberOfRows = driver.findElements(By.xpath(".//table/tbody/tr")).size();

        for (int i = 1; i <= numberOfRows; i++) {
            int numberOfColumn = driver.findElements(By.xpath(".//table/tbody/tr[" + i + "]/td")).size();
            for (int j = 1; j <= numberOfColumn; j++) {
                String t = driver.findElement(By.xpath(".//table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.println("vinit: " + t);
            }
        }
    }

    @Test
    public void test1() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/test/table.html");

        WebElement ele = driver.findElement(By.xpath(".//table/tbody"));

        List<WebElement> listEle= ele.findElements((By.xpath(".//tr")));

        int numberOfRows = listEle.size();


        for (int i = 0; i < numberOfRows; i++) {
            List<WebElement> colList = listEle.get(i).findElements(By.xpath(".//td"));
            int numberOfColumn = colList.size();
            for (int j = 0; j < numberOfColumn; j++) {
                String t = colList.get(j).getText();
                System.out.println("vinit: " + t);
            }
        }
    }
}