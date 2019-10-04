package com.idm.common.generateReports;

import org.testng.annotations.Test;

/**
 * @author evingoy TestNG default generates 3 types of reports, you dont need to
 *         do anything. After running this scenario, Refresh you project folder.
 *         1. Goto test-output -> Default Suite.html 2. emailable report.html 3.
 *         index.html
 */
public class GenerateReportusingTestNG {

    @Test
    public void test1() {
        System.out.println("Test1 passed");
    }

    // @Test
    public void test2() {
        System.out.println("Test2 passed");
    }

    // @Test
    public void test3() {
        System.out.println("Test3 passed");
    }
}
