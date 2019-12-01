package com.idm.ui.basic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;

public class NaveenaClass extends BaseClass {

	private String URL = "http://10.7.61.114:8080/";
	
	@BeforeClass
    public void beforeClass() {
        System.setProperty(ConstantsSelenium.GECKO_DRIVER_PROP, ConstantsSelenium.GECKO_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.IE_DRIVER_PROP, ConstantsSelenium.IE_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.ME_DRIVER_PROP, ConstantsSelenium.ME_DRIVER_PATH);
    }
	
	@Test
	public void test1() {
		fillData("Vinit", "Goyal", "vinitg@opentext.com", "vinitg@opentext");
	}
	
	private void fillData(String firstName, String lastName, String email, String password) {
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmPassword")).sendKeys(password);
		
		driver.findElement(By.id("signupform1")).click();
	}
}