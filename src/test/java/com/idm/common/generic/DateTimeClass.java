package com.idm.common.generic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeClass {

    public static String getDateInDetailedFormat() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();

        String date1 = dateFormat.format(date);
        System.out.println("Current date and time is " + date1);
        return date1;
    }
}
