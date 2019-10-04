package com.idm.ui.pageObjectModel.withPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LocatorsRepositoryUsingPageFactory {

    WebDriver driver;

    public LocatorsRepositoryUsingPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "user_login")
    @CacheLookup
    WebElement username;

    @FindBy(how = How.ID, using = "user_pass")
    @CacheLookup
    WebElement password;

    @FindBy(how = How.XPATH, using = ".//*[@id='wp-submit']")
    @CacheLookup
    WebElement submit_button;

    public void clickOnLoginButton(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submit_button.click();
    }
}