package com.idm.common.readAndWriteExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelUsingApachePOI {

    /**
     * Few observations while reading the different set of Data
     *
     * You need to make sure which kind of data you want to read.
     * To read String value you can call getStringCellValue() method.
     * To read Numeric value you can call getNumericCellValue() which will return double value which we
     * can typecast into int and then we can use in our test data.
     */
    // Note : To use .xlsx file use XSSF, to use .xls file use HSSF
    @Test
    public void testReadData() {

        try {
            // Specify the path of file
            File src = new File("C:\\Testing\\RandomFiles\\abc.xlsx");

            // load file
            FileInputStream fis = new FileInputStream(src);

            // Load workbook
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            // Load sheet- Here we are loading first sheetonly
            XSSFSheet sh1 = wb.getSheetAt(0);

            System.out.println("size: " + sh1.getRowBreaks().length);
            System.out.println("getLastCell umber : " + sh1.getRow(0).getLastCellNum());
            System.out.println("getLastCell umber : " + sh1.getRow(0).getPhysicalNumberOfCells());

            System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());

            // if data is numeric : then use the below statement
            // int
            // data=(int)wb.getSheetAt(0).getRow(0).getCell(1).getNumericCellValue();

            System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
            System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
            System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
            System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
            System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}