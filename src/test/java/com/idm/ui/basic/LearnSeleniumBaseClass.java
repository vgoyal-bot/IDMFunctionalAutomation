package com.idm.ui.basic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.BrowserFactory;
import com.idm.common.ConstantsSelenium;
import com.idm.ui.proxyAndCertificates.HandleDeveloperModeNotificationSSLDisabilities;

public class LearnSeleniumBaseClass extends BaseClass {

    static {
        // property to set Gecko driver path required for selenium 3 and to run
        // in firefox
        System.setProperty(ConstantsSelenium.GECKO_DRIVER_PROP1, ConstantsSelenium.GECKO_DRIVER_PATH);

        /*
         * if above property is not working or not opening the application in
         * browser then try below property
         * System.setProperty("webdriver.gecko.driver",
         * "C:\\Testing\\Selenium\\Jars\\GeckoDriver\\geckodriver.exe");
         */

        // Path to set property for chrome driver
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);

        // Path to set property for IE driver.
        System.setProperty(ConstantsSelenium.IE_DRIVER_PROP, ConstantsSelenium.IE_DRIVER_PATH);

        // Path to set property for Microsoft Edge driver.
        System.setProperty(ConstantsSelenium.ME_DRIVER_PROP, ConstantsSelenium.ME_DRIVER_PATH);

    }

    @Test
    public void basicFirefoxProgWithTitle() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.manage().window().maximize();
        System.out.println("browser title : " + driver.getTitle());
    }

    @Test
    public void basicChromeProg() {
        WebDriver driver = new ChromeDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void basicIEProg() {
        WebDriver driver = new InternetExplorerDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void openFacebookPageInChrome() {
        WebDriver driver = null;
        driver = HandleDeveloperModeNotificationSSLDisabilities.hideOrDisablePopupNotificationInChrome(driver);
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//input[@id='firstname']"));
        element.sendKeys("Vinit");
        System.out.println(element.getTagName());
        System.out.println(element.getClass());
        System.out.println(element.getAttribute("value"));
    }

    @Test
    public void openDemositePageUsingFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.DEMOSITE_URL);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("admin");
    }

    @Test
    public void testCheckBoxUsingFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.SELENIUM_PRACTISE_URL);

        WebElement checkBoxElement = driver.findElement(By.xpath("//input[@type='checkbox'][@id='sing']"));
        if (checkBoxElement.isDisplayed() && checkBoxElement.isEnabled()) {
            if (!checkBoxElement.isSelected()) {
                checkBoxElement.click();
            }
        }
    }

    @Test
    public void testRadioButtonUsingFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.SELENIUM_PRACTISE_URL);

        WebElement radioElement = driver.findElement(By.xpath("//input[@type='radio'][@id='java']"));
        if (radioElement.isDisplayed() && radioElement.isEnabled()) {
            if (!radioElement.isSelected()) {
                radioElement.click();
            }
        }
    }

    @Test
    public void testCSSXPathUsingFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.findElement(By.cssSelector("#u_0_7")).sendKeys("Vinit");
        driver.findElement(ByCssSelector.cssSelector("#u_0_9")).sendKeys("Goyal");
    }

    @Test
    public void testDropdownUsingFirefox() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);

        WebElement dropDown_day = driver.findElement(By.xpath("//*[@id='day']"));
        WebElement dropDown_month = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement dropDown_year = driver.findElement(By.xpath("//*[@id='year']"));

        Select daySelect = new Select(dropDown_day);
        Select monthSelect = new Select(dropDown_month);
        Select yearSelect = new Select(dropDown_year);

        if (dropDown_day.isDisplayed() && dropDown_day.isEnabled()) {
            daySelect.selectByIndex(28);
            monthSelect.selectByValue("7");
            yearSelect.selectByVisibleText("1989");
        }
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
     * This method is to capture the error message, once u login at naukri.com
     * with wrong email id, it will throw one error message we are simply
     * verifying that error message
     */
    @Test
    public void captureErrorMessage() {
        WebDriver driver = BrowserFactory.getChromeDriver("https://www.naukri.com");
        driver.findElement(By.xpath(".//*[@id='login_Layer']/div")).click();
        driver.findElement(By.xpath(".//*[@id='eLogin']")).sendKeys("anljasldf");

        String errorText = driver.findElement(By.xpath(".//*[@id='eLogin_err']")).getText();
        //verify error message
        if (("Please enter a valid Email ID").equals(errorText)) {
            System.out.println("Error Message Captured");
        } else {
            System.out.println("Error message not captured");
        }
    }

    /**
     * This method will first switch to all other popups one by one and will
     * close the driver of each popup and will switch to parent window after
     * closing all the popups
     */
    @Test
    public void handleMultiplePopups() {
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
    public void switchToMainWindow() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(ConstantsSelenium.NAUKRI_URL);

        String parentWindow = chromeDriver.getWindowHandle();

        Set<String> s1 = chromeDriver.getWindowHandles();
        System.out.println("Number of windows: " + s1.size());
        if (s1.size() != 1) {
            chromeDriver.switchTo().window(parentWindow);
        }
    }

    /**
     * This method shows two things: 1. Correct approach to switch focus to
     * child window. 2. How to switch driver to parent or child window.
     */
    @Test
    public void handleMultipleWindows() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.MULTIPLE_WINDOWS_URL);

        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.xpath(".//*[@href='http://www.google.com']")).click();

        // This approach will not switch focus
        String childWindow = driver.getWindowHandle();
        if (childWindow.equals(parentWindow)) {
            System.out.println("Handle at Parent window and focus can not be switched to child window");
        } else {
            System.out.println("Handle at Child window");
        }

        // This approach will switch focus to child window
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iter = windowHandles.iterator();
        while (iter.hasNext()) {
            childWindow = iter.next();
        }
        if (childWindow.equals(parentWindow)) {
            System.out.println("Handle at parent window");
        } else {
            System.out.println("Handle at child window");
        }

        // switch handle to parent window
        driver.switchTo().window(parentWindow);
        System.out.println("title : " + driver.getTitle());

        // switch handle to child window
        driver.switchTo().window(childWindow);
        System.out.println("title : " + driver.getTitle());
    }

    @Test
    public void handleMultipleFrames() throws InterruptedException {
        WebDriver chromeDriver = BrowserFactory
                .getChromeDriver("file:///C://Testing//Backup_1Feb2019_7PM//Testing//Selenium//utilities//frameClass.html");

        String parentWindow = chromeDriver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);
        chromeDriver.switchTo().frame(0);
        System.out.println("frame 1: " + chromeDriver.getTitle());
        chromeDriver.findElement(By.xpath(".//*[@id='menu-item-1741']/a")).sendKeys("vinitGoyal");
    }

    /**
     * Bootstrap login is a dialog box/popup window which page is displayed on
     * top of current page.
     */
    @Test
    public void handleBootstrapDialog() {
        WebDriver driver = BrowserFactory
                .getFirefoxDriver("http://seleniumpractise.blogspot.in/2016/11/handle-bootstrap-model-dialog-in.html");
        driver.findElement(By.xpath(".//button[text()='Click here to Login']")).click();
        driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/input[1]")).sendKeys("abc");
    }

    /**
     * When u click on signup button on goibibo website, it will open one
     * bootstrap dialog. but that bootstrap dialog is present inside one frame,
     * so to excess element of that bootstrap dialog - first we need to switch
     * to that frame.
     *
     */
    @Test
    public void handleBootstrapDialogWithFrame() {
        WebDriver driver = BrowserFactory.getFirefoxDriver("https://www.goibibo.com/");
        driver.findElement(By.xpath(".//*[@id='get_sign_up']")).click();
        driver.switchTo().frame("authiframe");
        driver.findElement(By.xpath(".//*[@id='authMobile']")).sendKeys("9717172394");
    }
}