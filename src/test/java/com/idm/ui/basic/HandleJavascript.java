package com.idm.ui.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.BrowserFactory;

public class HandleJavascript extends BaseClass {

	public void allInOneMethodForInterview() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.id("u_0_q"));
		
		js.executeScript("document.getElementById('email').value='vinit.itm@gmail.com';");
		js.executeScript("arguments[0].value='password'", element);
		js.executeScript("document.getElementById('u_0_q').click();");
		js.executeScript("arguments[0].click()",element);
		js.executeScript("document.getElementById('u_0_q').click();");		// radio button
		js.executeScript("document.getElementById('enter element id').checked=false;");		// checkbox
		js.executeScript("arguments[0].scrollIntoView(true);", element);		// to scroll till the mentioned element id.
		js.executeScript("scroll(0,1000)");		// to scroll down the page
		
		// set the background colour and border.
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);		
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px green');", element);		// set the border
		js.executeScript("document.location.reload");		// refresh the current browser
		
	}
	
	/**
	 * 1. Entering values in textbox by 2 different ways in javascript.
	 * 2. Click on button by two different ways in javascript.
	 */
	@Test
	public void loginTofbUsingJS() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='vinit.itm@gmail.com';");
		js.executeScript("arguments[0].value='password'", driver.findElement(By.id("pass")));
//		js.executeScript("document.getElementById('pass').value='password';");
		js.executeScript("document.getElementById('u_0_q').click();");
		//js.executeScript("arguments[0].click()",driver.findElement(By.id("u_0_q")));
	}
	
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

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));

        // now execute query which actually will scroll until that element is
        // not appeared on page.
        js.executeScript("arguments[0].scrollIntoView(true);", element);

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
    
    // to handle java script alert
    @Test
    public void handleAlert() {
    	 WebDriver driver=new FirefoxDriver();
         driver.manage().window().maximize();
         driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
         driver.findElement(By.xpath("//*[@id='content']/button")).click();

         Alert alert = driver.switchTo().alert();
         alert.accept();
    }
    
    @Test
    public void refreshBrowserWindow() throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");
        
        Thread.sleep(3000);
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.location.reload");
    }
}