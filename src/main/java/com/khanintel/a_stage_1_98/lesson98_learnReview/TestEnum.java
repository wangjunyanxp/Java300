package com.khanintel.a_stage_1_98.lesson98_learnReview;

/**
 * 就是自己在学到98课的时候，突然意识到自己没有学习过枚举类型
 */
public class TestEnum {

    /**
     * 1. 枚举，是需要创建一个类似于"类"的一个东西，其实就是个“类”，在编译的文件夹里看编译出来的.class文件就能知道了
     */

    /**
     * 可以看作是 InnerClass 的枚举
     */
    enum People {
        MAN,
        WOMAN
    }

    public static void main(String[] args) {


        /**
         * 枚举类型的方法
         * Day.values()
         * Day.valueOf("StringValue")
         */
        for (Day d: Day.values()) {
            System.out.println(d);
        }
        System.out.println(Day.valueOf("FRIDAY"));



        /**
         * 下面这句，会有 IllegalArgumentException
         * Exception in thread "main" java.lang.IllegalArgumentException: No enum constant com.khanintel.a_stage_1_98.lesson98_learnReview.Day.Monday
         */
        // System.out.println(Day.valueOf("Monday"));   //注意大小写




        /**
         * 创建实例、赋值
         * 枚举里面的值，都看作 static final 常量
         */
        Day d = Day.MONDAY;


        /**
         * 枚举，用于 switch case
         */
        switch (d) {
            /**
             * 注意，是 MONDAY ，不是 Day.MONDAY ！！！
             */
            case MONDAY:
                System.out.println(Day.MONDAY);
                break;
            case THURSDAY:
                System.out.println(Day.TUESDAY);
                break;
            default:
                System.out.println("Good Day");
                break;
        }


    }


}


/**
 * 作为单独的类的枚举
 * 里面随便用回车换行
 */
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY, SUNDAY
}