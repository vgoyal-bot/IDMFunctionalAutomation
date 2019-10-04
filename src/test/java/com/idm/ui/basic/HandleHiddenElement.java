package com.idm.ui.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;

/**
 * hidden element has coordinates 0,0 as they are hidden
 * @author evingoy
 */
public class HandleHiddenElement {

    /**
     * This will throw : ElementNotvIsible exception Reason : there are 2
     * elements radio buttons with id ='male'. in which first is hidden and
     * second is visible, by default it will click the first one. But we want to
     * click the second one. So we will use another way.
     */
    @Test
    public static void handleHiddenElement() {
        WebDriver driver = BrowserFactory
                .getFirefoxDriver("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
        try {
            driver.findElement(By.id("male")).click();
        } catch (ElementNotVisibleException ex) {
            System.out.println("inside catch statement of Element not visible exception");
            alternateWay(driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void alternateWay(WebDriver driver) {
        List<WebElement> listElement = driver.findElements(By.id("male"));
        for (WebElement ele : listElement) {
            if (ele.getLocation().getX() == 0 && ele.getLocation().getY() == 0) {
                System.out.println("Hidden element");
            } else {
                ele.click();
            }
        }
    }
}