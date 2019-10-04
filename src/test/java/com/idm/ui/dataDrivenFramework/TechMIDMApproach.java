package com.idm.ui.dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * In this class, we are using input excel sheet and taking that data from excel
 * sheet and converting into 2D Array and passing the data into script. We have
 * used ApachePOI to open the excel, we can also use JExcel
 *
 * @author evingoy
 */
public class TechMIDMApproach {

    @Test(dataProvider = "newData")
    public void test(String use, String use2, String use3) throws InterruptedException {
        System.out.println("Vinit under test");
        WebDriver driver = new FirefoxDriver();
        String url = "http://demosite.center/wordpress/wp-login.php";
        driver.get(url);

        // driver.findElement(By.id("user_login")).clear();
        // driver.findElement(By.id("user_login")).sendKeys(username);
        // driver.findElement(By.id("user_pass")).clear();
        // driver.findElement(By.id("user_pass")).sendKeys(password);
        // driver.findElement(By.id("wp-submit")).click();

        Thread.sleep(3000);
        AssertJUnit.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @DataProvider(name = "newData")
    public Object[][] techMDataProvider() throws Exception {
        return defreadExcel("MethodName3");
    }

    private Object[][] defreadExcel(String methodName) throws Exception {
        File file = new File("C:\\Work\\temp\\Book1.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowsSize = sheet.getPhysicalNumberOfRows();
        int desiredRowNumber = 0;
        int desiredNoOfColumns = 0;

        boolean datafound = false;

        for (int i = 0; i < rowsSize; i++) {
            if (sheet.getRow(i).getCell(0).toString().equals(methodName)) {
                datafound = true;
                desiredRowNumber = i;
                desiredNoOfColumns = sheet.getRow(i).getPhysicalNumberOfCells();
                break;
            }
        }

        Object[][] arrayTable;

        if (!datafound) {
            throw new Exception("Vinit - Method Name not present in all rows at column0");
        } else if (desiredNoOfColumns == 1) {
            throw new Exception("Vinit - No column present against the method name");
        } else {
            arrayTable = new Object[1][desiredNoOfColumns - 1];
            for (int j = 1; j < desiredNoOfColumns; j++) {              // At 0th position, MethodName will be present.
                arrayTable[0][j - 1] = sheet.getRow(desiredRowNumber).getCell(j).toString();
            }
        }
        return arrayTable;
    }
}