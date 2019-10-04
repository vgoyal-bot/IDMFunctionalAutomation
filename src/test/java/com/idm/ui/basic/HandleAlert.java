package com.idm.ui.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;

public class HandleAlert {

    @Test
    public void test() {
        WebDriver driver = BrowserFactory.getChromeDriver("http://www.ksrtc.in/oprs-web/");
        driver.findElement(By.xpath(".//*[@id='searchBtn']")).click();
        if (isAlertPresent(driver)) {
            Alert alert = driver.switchTo().alert();
            System.out.println("alert text: " + alert.getText());
            alert.accept();
        }
    }

    private boolean isAlertPresent(WebDriver driver) {
        try{
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
