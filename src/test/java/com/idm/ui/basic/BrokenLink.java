package com.idm.ui.basic;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;
import com.idm.common.BrowserFactory;

/**
 * Suppose we have one application which contains 400 links and we need to
 * verify the link is broken or not.
 *
 * Approach 1-Manual Process- Go to each link and verify the link is working or
 * not. Approach 2-Smart work- Write a code which will check all the link and
 * will verify the status as well.
 */
public class BrokenLink extends BaseClass {

    @Test
    public void test() {
        WebDriver driver = BrowserFactory.getFirefoxDriver("http://www.google.co.in/");

        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement ele : list) {
            String url = ele.getAttribute("href");
            System.out.println("url : " + url);
            verifyLinkActive(url);
        }
    }

    private void verifyLinkActive(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();

            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
            if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
                        + HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
        }
    }
}