package com.idm.ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithoutPageFactoryClass {

    WebDriver driver;
    By usernameXpath = By.id("");
    By passwordXpath = By.xpath("");

    public WithoutPageFactoryClass(WebDriver driver) {
        this.driver = driver;
    }

    private void setUserName(String username) {
        driver.findElement(usernameXpath).sendKeys(username);
    }

    private void setPassword(String password) {
        driver.findElement(passwordXpath).sendKeys(password);
    }

    public void loginToMainPage(String username, String password) {
        setUserName(username);
        setUserName(password);
    }
}
