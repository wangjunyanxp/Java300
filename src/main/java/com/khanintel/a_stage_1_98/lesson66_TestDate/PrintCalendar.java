package com.khanintel.a_stage_1_98.lesson66_TestDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 */
public class PrintCalendar {

    public static void main(String[] args) {

        /**
         * 这个版本，代码都是自己实现的
         * 每个月有多少天
         * 2月是28还是29天（leap year）
         */
        System.out.println("请输入时间，敲回车提交（参考: 2000-01-01）");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        printCalenderOfMonth(dateString);

        /**
         *  增加一些自己所不知道的函数，其实可以节省很多代码量
         *      calendarObj.getActualMaximum 的灵活使用
         *  对于下个例子非常有帮助
         */
        Calendar c = Calendar.getInstance();
        int year = 2000;
        int month = Calendar.FEBRUARY;
        int date = 2;
        // 故意设置成闰年的2月
        c.set(year, month, date);
        System.out.println(c.getTime());
        System.out.println(c.getActualMaximum(Calendar.DATE));
        System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(c.getActualMinimum(Calendar.DATE));
        System.out.println(c.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));

        /**
         * 运用 Calender 的函数来实现的功能
         */
        System.out.println("请输入时间，敲回车提交（参考: 2000-01-01）");
        scanner = new Scanner(System.in);
        dateString = scanner.nextLine();
        printCalenderOfMonthUsingJavaLib(dateString);

    }


    public static void printCalenderOfMonthUsingJavaLib(String dateString) {
        /**
         * 1. 获得日期
         * 2. 获得该月的第一天是周几（用于确认打印几个Tab）
         * 3. 获得该月有多少天，确认要打印多少天
         * 4. 打印
         */
        Date date = null;
        int afterSunday = 0;
        int daysOfMonth = 0;

        // 1
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 2, 3
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int theTargetDay = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, 1);

        afterSunday = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;

        daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 4 实现方法-1
        // 利用 计数器 j 来判断何时打印换行
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int j = 0;
        for (int i = 0; i<afterSunday; i++) {
            System.out.print("\t");
            j++; //j = afterSunday
        }
        for (int i = 0; i< daysOfMonth; i++) {
            if (j%7 == 0) {
                System.out.println();
            }
            System.out.print(i+1 + "\t");
            j++;
        }
        System.out.println();

        // 4 实现方法-2
        // 运用 calendar 的值来打印（包括换行）
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int i = 0; i<afterSunday; i++) {
            System.out.print("\t");
        }
        for (int i = 0; i< daysOfMonth; i++) {
            if (calendar.get(Calendar.DATE) == theTargetDay) {
                System.out.print("*");
            }
            System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println();





    }

    public static void printCalenderOfMonth(String dateString) {
        int[] day31Month = new int[] {Calendar.JANUARY, Calendar.MARCH, Calendar.MAY, Calendar.JULY, Calendar.AUGUST, Calendar.OCTOBER, Calendar.DECEMBER };
        int[] day30Month = new int[] {Calendar.APRIL, Calendar.JUNE, Calendar.SEPTEMBER, Calendar.NOVEMBER};

        Date date = null;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("输入的时间格式不对！");
        }

        Calendar c = new GregorianCalendar();
        c.setTime(date);

        int month;
        month = c.get(Calendar.MONTH);



        int monthContainDays;

        if (Arrays.binarySearch(day30Month,month) >= 0){
            monthContainDays = 30;
        } else if (Arrays.binarySearch(day31Month,month) >= 0) {
            monthContainDays = 31;
        } else {
            if (isLeapYear(c.get(Calendar.YEAR))) {
                monthContainDays = 29;
            } else {
                monthContainDays = 28;
            }
        }

        ArrayList<String> stringWholeMonth = new ArrayList<>();

        c.set(Calendar.DATE, 1);
        int beforeSundayDays = c.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;

        for(int i=0; i<beforeSundayDays; i++) {
            stringWholeMonth.add(" ");
        }
        for (int i=0; i<monthContainDays; i++) {
            stringWholeMonth.add(i+1+"");
        }

        System.out.println("日" + "\t" +  "一" + "\t" +  "二" + "\t" +  "三" + "\t" +  "四" + "\t" +  "五" + "\t" +  "六");
        for(int i=0; i<stringWholeMonth.size(); i++) {
            if (i%7==0 && i!=0) {
                System.out.println();
            }
            System.out.print(stringWholeMonth.get(i) + "\t");
        }
        System.out.println();

    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }









}
