package com.idm.ui.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.BrowserFactory;

public class HandleAlert extends BaseClass {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = BrowserFactory.getChromeDriver("http://www.ksrtc.in/oprs-web/");
        String xpath = ".//button[contains(text(),'Search for Bus')]";
        driver.findElement(By.xpath(xpath)).click();
        driver.manage().wait(3000);
        
        Alert al = driver.switchTo().alert();
        
        
        
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
    
    @Test
    public void passUsernameInAlert() throws InterruptedException {
    	WebDriver driver = BrowserFactory.getChromeDriver("http://www.ksrtc.in/oprs-web/");
    	Alert alert = driver.switchTo().alert();
    	alert.sendKeys("username"+ Keys.TAB + "password");
    	alert.accept();
    }
}
