package com.idm.common.readAndWriteExcel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Boolean;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcelUsingJExcel {

    public static void main(String args[]) {
        try {
            File src = new File("C:\\testing\\RandomFiles\\abcWrite.xls");

            WritableWorkbook writableWorkbook = Workbook.createWorkbook(src);

            WritableSheet writableSheet = writableWorkbook.createSheet("VinitSheet0", 0);
            WritableSheet writableSheet1 = writableWorkbook.createSheet("VinitSheet1", 1);
            WritableSheet writableSheet2 = writableWorkbook.createSheet("VinitSheet2", 2);

            // Create Cells with Cell coordinates (column, row).
            Label label0 = new Label(0, 0, "ColumnName_String");
            Label label1 = new Label(1, 0, "ColumnName_Number");
            Label label2 = new Label(2, 0, "ColumnName_Boolean");

            Label cell01 = new Label(0, 1, "Vinit");
            Label cell02 = new Label(0, 2, "Nidhi");

            Number num11 = new Number(1, 1, 20);
            Number num12 = new Number(1, 2, 20);

            Boolean bool21 = new Boolean(2, 1, true);
            Boolean bool22 = new Boolean(2, 2, false);

            writableSheet.addCell(label0);
            writableSheet.addCell(label1);
            writableSheet.addCell(label2);
            writableSheet.addCell(cell01);
            writableSheet.addCell(cell02);
            writableSheet.addCell(num11);
            writableSheet.addCell(num12);
            writableSheet.addCell(bool21);
            writableSheet.addCell(bool22);

            // Write and close the workbook
            writableWorkbook.write();
            writableWorkbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}