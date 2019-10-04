package com.idm.ui.pageObjectModel.withPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.idm.common.ConstantsSelenium;


/**
 * @author evingoy
 */
public class TestClassPageFactory {

    static {
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);
    }

    String username = "admin";
    String password = "demo123";

    /**
     */
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://demosite.center/wordpress/wp-login.php");

        LocatorsRepositoryUsingPageFactory loginPage = PageFactory.initElements(driver, LocatorsRepositoryUsingPageFactory.class);
        loginPage.clickOnLoginButton(username, password);
    }
}