package com.khanintel.a_stage_1_98.lesson66_TestDate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 */
public class TestCalender {

    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());

        c = new GregorianCalendar();
        System.out.println(c.getTime());

        c = GregorianCalendar.getInstance();
        System.out.println(c.getTime());

        Date d1 = c.getTime();
        System.out.println(c.getTime());
        System.out.println(d1);

        c.setTime(new Date());
        System.out.println(c.getTime());

        c.set(2000,0,1,0,0,0);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        //System.out.println(c.toString());
        System.out.println(c.getTime());

        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, 12);
        c.add(Calendar.DATE, -365);
        System.out.println(c.getTime());
        System.out.println(c.get(Calendar.YEAR));

    }


}
