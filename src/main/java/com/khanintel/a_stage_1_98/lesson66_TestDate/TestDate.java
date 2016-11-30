package com.khanintel.a_stage_1_98.lesson66_TestDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 */
public class TestDate {

    public static void main(String[] args) {

        Date d1 = new Date();
        System.out.println(d1.toString());

        long l1 = d1.getTime();
        d1.setTime(l1+600000);
        System.out.println(d1.toString());

        /**
         * DateFormat.getDateInstance();
         * DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
         *
         */

        DateFormat df = DateFormat.getDateInstance();
        System.out.println(df.format(d1));

        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        System.out.println(df.format(d1));

        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINESE);
        System.out.println(df.format(d1));

        df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.CHINA); System.out.println(df.format(d1));
        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA); System.out.println(df.format(d1));
        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA); System.out.println(df.format(d1));
        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA); System.out.println(df.format(d1));

        /**
         * [DateFormat]  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
         * [String]  df.format(d1)
         * [Date]    df.parse("2016-11-04 14:00:00");
         *
         */
        df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(df.format(d1));
        Date d2 = null;
        try {
            d2 = df.parse("2016年11月04日 14:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(new Date().getTime() - d2.getTime());
        System.out.println(new Date(new Date().getTime() - d2.getTime()));


        System.out.println(df.getCalendar().getTime());


    }





}
