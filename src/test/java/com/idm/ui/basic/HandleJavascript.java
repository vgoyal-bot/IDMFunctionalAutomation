package com.idm.ui.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;

public class HandleJavascript {

    @Test
    public void typeInSeleniumWithoutUsingSendKey() throws InterruptedException {
        FirefoxDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        driver.executeScript("document.getElementById('email').value='vinitgoyal@gmail.com';");
        driver.executeScript("document.getElementById('pass').value='password';");
        driver.executeScript("document.getElementById('u_0_q').click();");

        JavascriptExecutor jsexecutor = driver;
    }

    @Test
    public void clickInSeleniumIfButtonOrRadioButtonIsDisabled(){
        FirefoxDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("enter your application URL");
        driver.executeScript("document.getElementById('u_0_q').click();");
    }

    @Test
    public void uncheckCheckboxIfCheckBoxIsDisabled() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("enter your application URL");

        // This will execute JavaScript in your script
        ((JavascriptExecutor) driver).executeScript("document.getElementById('enter element id').checked=false;");
    }

    /**
     * Let say we want to get the text of one element which is not visible on
     * the page but need to scroll down to see. So, for that first we need the
     * xpath till that point we will scroll down and then we will capture the
     * text.
     */
    @Test
    public void scrollIntoViewUsingjavaScript(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");

        JavascriptExecutor je = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));

        // now execute query which actually will scroll until that element is
        // not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);", element);

        // Extract the text and verify
        System.out.println(element.getText());
    }

    @Test
    public void scrollPageUpAndDown() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://jqueryui.com");

        // Wait for 5 second
        Thread.sleep(5000);

        // This will scroll page 400 pixel vertical
        ((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
    }

    @Test
    public void highlightElement() throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");

        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebElement username= driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", username);
        Thread.sleep(500);
        js.executeScript("arguments[0].setAttribute('style','border: solid 2px green');", password);
    }

    /**
     *
     */
    @Test
    public void handleXYCoordinates() {
        WebDriver driver = BrowserFactory.getFirefoxDriver("");
        WebElement element = driver.findElement(By.xpath(""));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // try to click using y coordinates
        js.executeScript("window.scrollTo(0,' + element.getLocation().y + ')");
        element.click();

        // try to click using x coordinates
        js.executeScript("window.scrollTo(0,' + element.getLocation().x + ')");
        element.click();
    }
}