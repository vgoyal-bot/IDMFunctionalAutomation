package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
public class ParallelExecution extends BaseClass {
    @Test    
    public void executSessionOne() throws InterruptedException{
            //First session of WebDriver
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            driver.get("http://demo.guru99.com/V4/");
            //find user name text box and fill it
            driver.findElement(By.name("uid")).sendKeys("Driver 1");
            Thread.sleep(10000);

            System.out.println("executSessionOne is completed");
            driver.quit();
        }
        
    @Test    
        public void executeSessionTwo() throws InterruptedException{
            //Second session of WebDriver
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        driver.get("http://www.facebook.com");
        Thread.sleep(10000);

        System.out.println("executSessionTwo is completed");
        driver.quit();
    }
        
    @Test    
        public void executSessionThree() throws InterruptedException{
            //Third session of WebDriver
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        driver.get("http://www.google.com");
        Thread.sleep(10000);
        
        System.out.println("executSessionThree is completed");
        driver.quit();
        }        
}