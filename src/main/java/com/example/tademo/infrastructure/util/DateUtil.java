package com.example.tademo.infrastructure.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sdformat.parse(dateString);
    }

    public static Date parseDateTime(String dateTimeString) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
        return sdformat.parse(dateTimeString);
    }

    public static String formatDate(Date date){
        SimpleDateFormat sdformat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sdformat.format(date);
    }

    public static String formatDateTime(Date date){
        SimpleDateFormat sdformat = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
        return sdformat.format(date);
    }

}
