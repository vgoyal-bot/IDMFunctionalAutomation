package com.idm.ui.basic;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.idm.common.ConstantsSelenium;

/**
 * Limitations of Robot Class:
 * 1. Robot class can work only on current window, so if you have to switch between different windows, Robot class will not work.
 * 2. If you are using X, Y coordinates for your test, then script will behave differently for different resolutions.
 * 3. If you are executing test script in VM, then it will have more failures.
 * @author vinitg
 *
 */
public class RobotClass {

    static {
        // to know about the below lines: what they do check static block of
        // LearnSeleniumBaseClass.java
        System.setProperty(ConstantsSelenium.GECKO_DRIVER_PROP1, ConstantsSelenium.GECKO_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.IE_DRIVER_PROP, ConstantsSelenium.IE_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.ME_DRIVER_PROP, ConstantsSelenium.ME_DRIVER_PATH);
    }

    /**
     * Step 1- We have to copy the file location in system clipboard. Step 2- We
     * have to click on upload button and use CTR+V and ENTER. Note- Robot class
     * each key has to press and release respectively
     *
     * @throws AWTException
     * @throws InterruptedException
     */
    @Test
    public void uploadFileUsingRobotClass() throws AWTException, InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.MONSTER_URL);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='wordresume']")).click();

        // Copy path to clipboard
        StringSelection sel = new StringSelection("C:\\Testing\\Resumes\\VinitGoyalResume.doc");
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipBoard.setContents(sel, null);

        Robot robot = new Robot();
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Test
    public void screenshotUsingRobotClass() throws Exception {

        BufferedImage image = new Robot()
                .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        ImageIO.write(image, "png", new File("C:\\Selenium\\CurrentScreenshot.png"));
    }
}