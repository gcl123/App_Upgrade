package com.tt.javaserver.web.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by feng on 12/11/15.
 */
public class DateTimeUtils {

    private static DateFormat CHINESE_DATE_FORMAT = new SimpleDateFormat
            ("yyyy年MM月dd日");

    private static DateFormat DEFAULT_FORMAT = new SimpleDateFormat
            ("yyyy-MM-dd");

    private static DateFormat DEFAULT_TIME_FORMAT = new SimpleDateFormat
            ("yyyy年MM月dd日 HH:mm:ss");

    private static DateFormat FULL_TIME_FORMAT = new SimpleDateFormat
            ("yyyyMMddHHmmss");


    private static Date parse(String str, DateFormat format) {
        try {
            return format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parse(String str) {
        return parse(str, DEFAULT_FORMAT);
    }

    public static String format(Date date) {
        return format(date, DEFAULT_FORMAT);
    }

    private static String format(Date date, DateFormat format) {
        return format.format(date);
    }

    public static Date parseChinese(String str) {
        return parse(str, CHINESE_DATE_FORMAT);
    }

    public static String formatChinese(Date date) {
        return format(date, CHINESE_DATE_FORMAT);
    }

    public static String formatTime(Date date) {
        return format(date, DEFAULT_TIME_FORMAT);
    }

    public static int compareDate(Date d1, Date d2) {

        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("date is null");
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(d1);
        int year1 = calendar1.get(Calendar.YEAR);
        int month1 = calendar1.get(Calendar.MONTH);
        int day1 = calendar1.get(Calendar.DATE);
        Date dd1 = parse(year1 + "-" + (month1 + 1) + "-" + day1,
                DEFAULT_FORMAT);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(d2);
        int year2 = calendar2.get(Calendar.YEAR);
        int month2 = calendar2.get(Calendar.MONTH);
        int day2 = calendar2.get(Calendar.DATE);
        Date dd2 = parse(year2 + "-" + (month2 + 1) + "-" + day2,
                DEFAULT_FORMAT);
        return dd1.compareTo(dd2);
    }

    public static String formatChinese(String str) {
        if (str.indexOf("-") >= 0) {
            return formatChinese(parse(str));
        }
        return str;
    }

    public static String formatFullTime(long time) {
        return format(new Date(time), FULL_TIME_FORMAT);
    }

    public static int calculateAge(Date birthday) {
        Date d = new Date();
        if (d.compareTo(birthday) <= 0) {
            throw new RuntimeException("Invalid Birthday:" + birthday);
        }
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        Calendar cBirthday = Calendar.getInstance();
        cBirthday.setTime(birthday);
        int yearDiff = now.get(Calendar.YEAR) - cBirthday.get(Calendar.YEAR);
        int monthDiff = now.get(Calendar.MONTH) - cBirthday.get(Calendar.MONTH);
        int dateDiff = now.get(Calendar.DATE) - cBirthday.get(Calendar.DATE);
        return yearDiff - ((monthDiff < 0 || 0 == monthDiff && dateDiff < 0)
                ? 1 : 0);
    }

    public static void main(String[] args) {
        String s = "2015-3-25";
        Date d = DateTimeUtils.parse(s);
//        Date date = DateTimeUtils.parseChinese(s);
//        Date now = new Date();
//        System.out.println(DateTimeUtils.compareDate(date, now));
//        System.out.println(formatChinese(s));
    }


}
