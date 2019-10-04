package com.idm.ui.pageObjectModel.withoutPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.idm.common.ConstantsSelenium;


/**
 * What is Page Object model using Selenium Webdriver?
 *
 * 1- It is design pattern in which will help you to maintain the code and code
 * duplication, which is a crucial thing in Test automation.
 *
 * 2- You can store all locators and respective methods in the separate class
 * and Call them from the test in which you have to use.So the benefit from this
 * will be if any changes in Page then you do not have to modify the test simply
 * modify the respective page and that all.
 *
 * 3- You can create a layer between your test script and application page,
 * which you have to automate.
 *
 * 4- In other words, it will behave as Object repository where all locators are
 * saved.
 *
 * @author evingoy
 */
public class TestClass {

    static {
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);
    }

    String username = "admin";
    String password = "demo123";

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://demosite.center/wordpress/wp-login.php");

        LocatorsRepository loginPage = new LocatorsRepository(driver);
        loginPage.clickOnLoginButton(username, password);
    }
}