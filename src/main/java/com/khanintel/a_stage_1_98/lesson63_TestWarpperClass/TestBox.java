package com.khanintel.a_stage_1_98.lesson63_TestWarpperClass;

/**
 */
public class TestBox {

    public static void main(String[] args) {
        Integer i1 = 1000;
        int i2 = i1.intValue();
        int i3 = i1.intValue();


        Integer i4 = 128;
        Integer i5 = 128;
        System.out.println(i4==i5);  // false

        Integer i10 = -129;
        Integer i11 = -129;
        System.out.println(i10==i11); // false

        /**
         * 在[-128, 127]的范围内，Integer还是被作为基本数据类型 byte 来使用
         */
        Integer i6 = 127;
        Integer i7 = 127;
        System.out.println(i6==i7); // true

        Integer i8 = -128;
        Integer i9 = -128;
        System.out.println(i8==i9); // true

    }

}
