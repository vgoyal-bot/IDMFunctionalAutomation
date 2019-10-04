package com.idm.ui.proxyAndCertificates;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandleProxy {

    public static void main(String[] args) {

        // Create proxy class object
        Proxy p = new Proxy();
        p.setHttpProxy("localhost:7777");

        // Create desired Capability object
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(CapabilityType.PROXY, p);

        WebDriver driver = new FirefoxDriver(cap);
    }
}