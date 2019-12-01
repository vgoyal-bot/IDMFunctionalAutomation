package com.idm.common.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.idm.common.BaseClass;

public class VerifyImage extends BaseClass{   
	
	@Test
	public void test() {									
		String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";					
		WebDriver driver = new ChromeDriver();					

		//click on the "Facebook" logo on the upper left portion		
		driver.findElement(By.xpath(".//a[@title='Go to Facebook home']")).click();					

		//verify that we are now back on Facebook's homepage		
		if (driver.getTitle().equals("Facebook - log in or sign up")) {							
			System.out.println("We are back at Facebook's homepage");					
		} else {			
			System.out.println("We are NOT in Facebook's homepage");					
		}		
		driver.close();		
	}	
	
	@Test
	public void CheckImage() throws Exception {
		WebDriver driver = new ChromeDriver();	
		String baseUrl = "https://www.naukri.com";			
		String xpath = ".//a[@class='fl nLogo']/img";
		driver.get(baseUrl);
		WebElement ImageXpath = driver.findElement(By.xpath(xpath));
	        
	        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageXpath);
	        if (!ImagePresent){
	             System.out.println("Image not displayed.");
	        }else{
	            System.out.println("Image displayed.");
	        }
		}	
}