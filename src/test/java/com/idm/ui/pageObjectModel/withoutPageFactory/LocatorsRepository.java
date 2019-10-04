/**
 *
 */
package com.idm.ui.pageObjectModel.withoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model using Selenium Webdriver without PageFactory.
 *
 * Consider you have login page where username, password, and login button is
 * present. I will create a separate Login Page, will store three locators, and
 * will create methods to access them.
 *
 * Now I want to design test case so I can use the Login class, which I created
 * and can call the methods accordingly.
 *
 * This Login class will be used by all the scripts, which you will create in
 * future so if any changes happened then you have to update only Login Class
 * not all the test cases.
 */
public class LocatorsRepository {

    WebDriver driver;

    public LocatorsRepository(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLoginButton(String username, String password) {
        driver.findElement(getuserName()).sendKeys(username);
        driver.findElement(getuserPassword()).sendKeys(password);
        driver.findElement(getLoginButton()).click();
    }

    private By getuserName() {
        return By.id("user_login");
    }

    private By getuserPassword() {
        return By.xpath(".//*[@id='user_pass']");
    }

    private By getLoginButton() {
        return By.name("wp-submit");
    }
}
