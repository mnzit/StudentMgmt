package com.nepalaya.studentmgmt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date formatDate(String date, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }
    public static java.sql.Date convertJavaDateToSQLDate(
            Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = new java.sql.Date(javaDate.getTime());
        }
        return sqlDate;
    }
}
