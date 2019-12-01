package com.testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Step to run this test case through command prompt : 1. Create testng.xml from
 * this class. by right clicking on this class, Select TestNG -> Create TestNG
 * Class. It will create testNg.xml.
 *
 * 2. To verify right click on TestNg.xml and run as testng Test. it will run
 * the desired test case.
 *
 * 3. Make sure to add suiteXmlFile tag in pom.xml, it will pick the file from there, if default value of suiteXmlFile is set to testNg.xml then it will execute automatically, by using command : mvn test. Else use command : mvn test -DsuiteXmlFile=testNg.xml
 *
 * @author evingoy
 */
public class TestSeleniumUsingCommandPrompt {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Run before Suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Run before class");
	}
	
    @Test
    public void test1() {
        System.out.println("Test1 Done Successfully...");
    }

    @Test
    public void test2() {
        System.out.println("Test2 Done Successfully...");
    }

    @Test
    public void test3() {
        System.out.println("Test3 Done Successfully...");
    }
    
    @BeforeMethod
	public void beforeMethod() {
		System.out.println("Run before method");
	}
    
    @AfterMethod
	public void afterMethod() {
		System.out.println("Run after method");
	}
}
