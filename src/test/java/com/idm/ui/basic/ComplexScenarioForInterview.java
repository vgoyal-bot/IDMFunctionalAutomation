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
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;

public class ComplexScenarioForInterview extends BaseClass {

    /**
     Difference between driver.get and driver.navigate.to
     A : driver.get and driver.navigate to performs the same function, the only diffeernece is driver.get
     refreshes the page whereas driver.navigate.to navigates to the url and does not refreshes the page.
     As driver.get- refreshes the page so history wil be lost, wherras driver.navigate.to - navigate the to that specific url - history will be retained.

     */
	@Test
	public void test2() {
		WebDriver driver = new ChromeDriver();		
		String baseUrl = "https://www.facebook.com";
					
		driver.get(baseUrl);
		driver.navigate().to(baseUrl);
		driver.get(baseUrl);
	}
	
    @Test
    public void testBootstrapDropdownUsingFirefox() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.SELENIUM_BOOTSTRAP_URL);
        WebElement bootStrapElement = driver.findElement(By.cssSelector("#menu1"));
        if (bootStrapElement.isDisplayed() && bootStrapElement.isEnabled()) {
            if (!bootStrapElement.isSelected()) {
                bootStrapElement.click();
            }
        }
        List<WebElement> bootStrapElements = driver
                .findElements(By.xpath("//*[@id='menu1']//following::ul[@class='dropdown-menu']//child::li"));
        for (WebElement element : bootStrapElements) {
            if (element.getText().equalsIgnoreCase("JavaScript")) {
                Thread.sleep(3000);
                element.click();
            }
        }
    }

    @Test
    /**
     * Robot class is a separate class in Java which will allow us to perform
     * multiple tasks based on our requirement. It generally will throw AWT
     * exception so we need to deal with it accordingly. Using Robot class, we
     * can simulate keyboard event in Selenium. To use keyboard events you have
     * to use to a method of Robot class.
     *
     * Robot Class in Selenium Webdriver uses keyPress() and keyRelease(). Each
     * key has to be press and release respectively.
     *
     * Scenario- Which cover enter key 1- Open Facebook. 2- Enter Username and
     * password. 3- Using robot class press Enter button.
     *
     * @throws AWTException
     */
    public void progUsingRobotClass() throws AWTException {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.DEMOSITE_URL);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("demo123");

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * This method will first switch to all other popups one by one and will
     * close the driver of each popup and will switch to parent window after
     * closing all the popups
     */
    @Test
    public void handleMultiplePopupsOrWindows() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.naukri.com/");

        String parentWindow = chromeDriver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);

        Set<String> s1 = chromeDriver.getWindowHandles();
        Iterator<String> iter = s1.iterator();
        while (iter.hasNext()) {
            String childWindow = iter.next();
            if (!parentWindow.equals(childWindow)) {
                chromeDriver.switchTo().window(childWindow);
                System.out.println("Child window : " + chromeDriver.switchTo().window(childWindow).getTitle());
                chromeDriver.close();
            }
        }
        chromeDriver.switchTo().window(parentWindow);
    }

    @Test
    public void handleMultipleFrames() throws InterruptedException {
        WebDriver chromeDriver = BrowserFactory
                .getChromeDriver("file:///C://Testing//Selenium//utilities//frameClass.html");

        String parentWindow = chromeDriver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);
        chromeDriver.switchTo().frame(0);
        System.out.println("frame 1: " + chromeDriver.getTitle());
        chromeDriver.findElement(By.xpath(".//*[@id='menu-item-1741']/a")).sendKeys("vinitGoyal");
    }

    /**
     * this is concept of object repository, in which web element are stored in
     * separate property file.
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        File file = new File("C:\\Testing\\Selenium\\utilities\\ObjectRepo.properties.txt");

        FileInputStream fis = new FileInputStream(file);
        Properties property = new Properties();
        property.load(fis);

        System.out.println("Property class loaded");

        // Open FirefoxBrowser
        WebDriver driver = BrowserFactory.getFirefoxDriver(ConstantsSelenium.FACEBOOK_URL);

        driver.findElement(By.xpath(property.getProperty("facebook.login.username.xpath")))
        .sendKeys("Selenium@gmail.com");
        driver.findElement(By.xpath(property.getProperty("facebook.login.password.xpath"))).sendKeys("adsadasdas");
        driver.findElement(By.xpath(property.getProperty("facebook.login.Signup.xpath"))).click();
    }

    @Test
    public void sendReportThroughEmail() {
        SendReportThroughEmail.main(null);

    }

    /**
     * options.addArguments("--disable--extensions"); driver = new
     * ChromeDriver(options);
     */
    // ** file upload download
    // wait in selenium
    // action, robot, autoIt
    // XPath - See Doc also
    // Database testing using selenium
    // Exception

}