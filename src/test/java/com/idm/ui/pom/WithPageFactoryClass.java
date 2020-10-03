package com.idm.ui.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class WithPageFactoryClass {

	@FindBy(id = "username")
    WebElement usernameElement;

    @FindBy(xpath = ".//input[@name = 'password']")
    WebElement passwordElement;

    WebDriver driver;

    public WithPageFactoryClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void setUsername(String username) {
        usernameElement.sendKeys(username);
    }

    private void setPassword(String password) {
        passwordElement.sendKeys(password);
    }

    public void loginToMainPage(String username, String password) {
        setUsername(username);
        setPassword(password);
    }
}
