package com.idm.common;

import org.testng.annotations.BeforeSuite;

public class BaseClass {

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty(ConstantsSelenium.GECKO_DRIVER_PROP, ConstantsSelenium.GECKO_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.CHROME_DRIVER_PROP, ConstantsSelenium.CHROME_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.IE_DRIVER_PROP, ConstantsSelenium.IE_DRIVER_PATH);
        System.setProperty(ConstantsSelenium.ME_DRIVER_PROP, ConstantsSelenium.ME_DRIVER_PATH);
    }
}