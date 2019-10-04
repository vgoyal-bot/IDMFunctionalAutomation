package learn.automation.selenium.eventListener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Note- We generally use Listener to generate log events
 *
 * @author evingoy
 *
 */
public class ActivityCapture implements WebDriverEventListener {

    public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
    }

    /**
     * we are simply printing on console and this method will automatically
     * called once click events done.
     */
    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        System.out.println("After click " + arg0.toString());
    }

    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        System.out.println("After FindBy " + arg0.toString());
    }

    @Override
    public void afterNavigateBack(WebDriver arg0) {
        System.out.println("After navigating back " + arg0.toString());
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {
        System.out.println("After navigating forword " + arg0.toString());
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
        System.out.println("After navigating " + arg0.toString());
        System.out.println("After navigating " + arg1.toString());
    }

    @Override
    public void afterScript(String arg0, WebDriver arg1) {
    }

    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        System.out.println("before click " + arg0.toString());
    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        System.out.println("before FindBY " + arg0.toString());
    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
        System.out.println("Before navigating back " + arg0.toString());
    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
        System.out.println("Before navigating Forword " + arg0.toString());
    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {
        System.out.println("Before navigating " + arg0.toString());
        System.out.println("Before navigating " + arg1.toString());
    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1) {
    }

    @Override
    public void onException(Throwable arg0, WebDriver arg1) {
        System.out.println("Testcase done" + arg0.toString());
        System.out.println("Testcase done" + arg1.toString());
    }

    @Override
    public void afterNavigateRefresh(WebDriver arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeNavigateRefresh(WebDriver arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        // TODO Auto-generated method stub

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        // TODO Auto-generated method stub

    }
}