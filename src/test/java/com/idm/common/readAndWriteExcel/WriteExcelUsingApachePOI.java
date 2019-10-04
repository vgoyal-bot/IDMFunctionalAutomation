package com.idm.common.readAndWriteExcel;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUsingApachePOI {

    public static void main(String[] args) {

        try {
            // load the workbook
            XSSFWorkbook wb = new XSSFWorkbook();

            // get the sheet which you want to modify or create
            XSSFSheet sh1 = wb.createSheet("VinitSheet1");

            // here createCell will create column

            // and setCellvalue will set the value

            sh1.createRow(0).createCell(0).setCellValue("2.41.0");

            sh1.createRow(1).createCell(0).setCellValue("2.5");
            // here we need to specify where you want to save file

            FileOutputStream fout = new FileOutputStream(new File("C:\\testing\\RandomFiles\\testWrite.xlsx"));

            // finally write content

            wb.write(fout);

            // close the file

            fout.close();

            System.out.println("Successfully done");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());

        }

    }

}