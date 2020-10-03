package com.idm.ui.dataDrivenFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;

/**
 * We have so many frameworks like Keyword driven framework, Hybrid Framework,
 * POM that is Page object model and data driven framework, each framework
 * having its own feature so we need to decide which framework to choose for
 * this project.
 *
 *
 * This framework purely depends on data and data source can be anything like
 * Excel file, CSV File, database.
 *
 * In data driven framework script or logic part will be separated from Data
 * part, it means so if any changes happen we do not have to modify all the test
 * cases. Example-
 *
 * I have to create 50 Gmail accounts so I have two approaches to do this
 *
 * First- I can create 50 scripts and run them.
 *
 * Second- I can keep all the data separate in the file and changes the data
 * only that is required for script and script will be only one. In future, any
 * changes in my application then I have to modify my one script only not the
 * scripts.
 *
 * In simple words when we have to execute the same script with multiple sets of
 * data we will adopt data driven framework
 *
 * In this class, we are taking data from 2D Array and passing the data into
 * script.
 *
 * @author evingoy
 *
 */
public class DataDrivenFrameworkUsing2DArray {

    WebDriver driver;

    @Test(dataProvider = "wordPressData")
    public void test(String username, String password, String e) throws InterruptedException {
        driver = BrowserFactory.getFirefoxDriver(ConstantsSelenium.DEMOSITE_URL);
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        

        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "wordPressData")
  public String[][] dataProviderMethod() {
        String[][] arrString = new String[3][2];
        arrString[0][0] = "admin1";
        arrString[0][1] = "demo1";
        arrString[1][0] = "admin";
        arrString[1][1] = "demo123";
        arrString[2][0] = "admin2";
        arrString[2][1] = "demo1234";
        
        return arrString;
    }
}