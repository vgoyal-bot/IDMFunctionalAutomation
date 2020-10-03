package com.idm.ui.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPOM {
    WebDriver driver;
    WithoutPageFactoryClass obj;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginPage() {
        obj = new WithoutPageFactoryClass(driver);
        obj.loginToMainPage("username", "password");
    }
}
