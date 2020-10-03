package com.idm.ui.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.ConstantsSelenium;

/**
 * Different Action class method name and usage:
 * 1. moveToElement(WebElement)-- Mouse Hover
 * 2. contextClick()-- Right click on page
 * 3. contextClick(WebElement)-- Right click on specific Element
 * 4. sendKeys(KEYS.TAB)--For keyboard events
 * 5. clickAndHold(WebElement)--Click on element and hold until next operation
 * 6. release() Release the current control
 * @author vinitg
 */
public class ActionClass extends BaseClass{

	@Test
	public void allInOneForINterview() {
		WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("q"));
        WebElement draggableElement = driver.findElement(By.name("q"));
        WebElement droppableElement = driver.findElement(By.name("q"));
        
        Actions act = new Actions(driver);
        act.contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
        											.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        
        act.contextClick(element).sendKeys(Keys.ARROW_DOWN)
        											.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        
        act.moveToElement(element).build().perform();;
        
        act.moveToElement(element).click().keyDown(element, Keys.SHIFT).sendKeys("vinit").keyUp(Keys.SHIFT)
        											.sendKeys(".itm").doubleClick().contextClick().build().perform();
        
        act.dragAndDrop(draggableElement, droppableElement).build().perform();
	}
	
    /**
     * contextClick()-- Right click on page
     */
    @Test
    public void actionClass() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);
        act.contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
    
    /**
     * contextclick(element) - it will right click on particular element.
     */
    @Test
    public void testContextClick() {
    	WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        
        new Actions(driver).contextClick(driver.findElement(By.name("q"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    @Test
    public void actionMoveToElement() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/selenium/newtours/");

        WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver.findElement(
                By.xpath("//html/body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr"));

        Actions action = new Actions(driver);
        Action mouseOverHome = action.moveToElement(link_Home).build();

        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);
        mouseOverHome.perform();
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
    }

    @Test
    public void seriesOfActions() {
        WebDriver driver = new FirefoxDriver();
        driver.get(ConstantsSelenium.FACEBOOK_URL);
        driver.manage().window().maximize();

        WebElement emailElement = driver.findElement(By.id("email"));

        Actions actions = new Actions(driver);
        Action seriesOfActions = actions.moveToElement(emailElement).click().keyDown(emailElement, Keys.SHIFT)
                .sendKeys("vinit").keyUp(Keys.SHIFT).sendKeys(".itm").doubleClick().contextClick().build();
        seriesOfActions.perform();
    }

    @Test
    public void drapANdDropUsingActionClass() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

        WebElement draggableElement = driver.findElement(By.xpath(".//*[@id='draggable']"));
        WebElement droppableElement = driver.findElement(By.xpath(".//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        Action action = actions.dragAndDrop(draggableElement, droppableElement).build();
        System.out.println(droppableElement.getCssValue("background-color"));
        action.perform();
        System.out.println(droppableElement.getCssValue("background-color"));
    }

    @Test
    public void rightClick() throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath(".//*[@id='_eEe']/a[6]"))).sendKeys(Keys.DOWN)
        .sendKeys(Keys.ENTER).build().perform();
    }
}