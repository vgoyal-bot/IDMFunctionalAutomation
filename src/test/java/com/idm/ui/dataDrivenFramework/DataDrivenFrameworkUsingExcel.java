package com.idm.ui.dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.idm.common.BrowserFactory;

/**
 * In this class, we are using input excel sheet and taking that data from excel
 * sheet and converting into 2D Array and passing the data into script. We have
 * used ApachePOI to open the excel, we can also use JExcel
 *
 *Points :
 *  1. Number of arguments in test method should match with number of columns otherwise it will throw some argument mismatch exceptio.
 *  2. Value of cell in excel can be blank it will take as null. 
 *
 * @author evingoy
 */
public class DataDrivenFrameworkUsingExcel {

    @Test(dataProvider = "wordPressData")
    public void test(String username, String password) throws InterruptedException {
        WebDriver driver = BrowserFactory.getChromeDriver("http://demosite.center/wordpress/wp-login.php");

        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();

        Thread.sleep(3000);
        AssertJUnit.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @DataProvider(name = "wordPressData")
    public String[][] dataProviderMethod() throws InvalidFormatException, IOException {
        File file = new File("C:\\Work\\temp\\Book1.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowsSize = sheet.getPhysicalNumberOfRows();

        String[][] arrStr = new String[rowsSize][];
        // Convert excel into 2D arrays
        for (int i = 0; i < rowsSize; i++) {
            int colSize = sheet.getRow(i).getPhysicalNumberOfCells();
            for (int j = 0; j < colSize; j++) {
                arrStr[i][j] = sheet.getRow(i).getCell(j).toString();
                System.out.println("arrStr" + i + j + " : " + arrStr[i][j]);
            }
        }
        workbook.close();
        return arrStr;
    }
}