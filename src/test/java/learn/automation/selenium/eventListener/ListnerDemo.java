package learn.automation.selenium.eventListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * There are 2 main things in listener :
 * 
 * 1- WebDriverEventListener – This is an interface, which have some predefined
 * methods so we will implement all of these methods.
 * 2-EventFiringWebDriver- This is an class that actually fire Webdriver event.
 * 
 * Why we are using Webdriver Listeners If you talk about Webdriver we are doing
 * some activity like type, click, navigate etc this is all your events which
 * you are performing on your script so we should have activity which actually
 * will keep track of it. Take an example if you perform click then what should
 * happen before click and after click.
 * 
 * @author evingoy
 */
public class ListnerDemo {

    public static void main(String[] args) {
        System.out.println("Started");

        WebDriver driver = new FirefoxDriver();

        EventFiringWebDriver event1 = new EventFiringWebDriver(driver);

        ActivityCapture handle = new ActivityCapture();
        event1.register(handle);
        event1.navigate().to("http://www.facebook.com");

        event1.findElement(By.id("email")).sendKeys("asdsadsa");
        event1.findElement(By.id("loginbutton")).click();
        event1.quit();

        event1.unregister(handle);

        System.out.println("End");
    }
}