package com.idm.common.readAndWriteExcel;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelUsingJExcel {

    @Test
    public void TestReadData() {

        // You need to use File class which will ask for file location.I
        // specified base// directory //using dot(.) operator then inside data
        // folder I have testdata.xls// stored

        File src = new File("C:\\testing\\RandomFiles\\abc.xls");

        try {
            Workbook wb = Workbook.getWorkbook(src);
            Sheet sh1 = wb.getSheet(0);
            System.out.println("sheet name: " + sh1.getName());

            // Sheet is loaded then we have to read cell using two arguments
            // getCell(column,row)
            Cell c1 = sh1.getCell(0, 0);

            // Cell is loaded then using getContents method we have to extract
            // the data using getContents() methods
            // this method will always return you String.
            String data1 = c1.getContents();

            // Print the data
            System.out.println(data1);
            System.out.println("Sheet data is " + data1);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}