package com.khanintel.a_stage_1_98.lesson63_TestWarpperClass;

/**
 * 包装类
 */
public class TestWarpperClass {

    public static void main(String[] args) {
        Integer i1 = new Integer(100);
        Integer i2 = 200;

        Integer i3 = new Integer("128");
        Integer i4 = Integer.parseInt("400");

        int i5 = i3.intValue();
        double i6 = i3.doubleValue();
        byte i7 = i3.byteValue();


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MAX_EXPONENT);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MIN_EXPONENT);
        System.out.println(Double.MIN_NORMAL);

        Boolean b1 = new Boolean(true);
        boolean b2 = b1.booleanValue();

        Character c1 = new Character('a');
        char c2 = c1.charValue();

        System.out.println(b2 + " " + c2);




    }
}
