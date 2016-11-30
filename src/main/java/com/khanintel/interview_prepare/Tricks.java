package com.khanintel.interview_prepare;

/**
 *
 * 一些小技巧
 *
 */
public class Tricks {

    public static void main(String[] args) {



    }


    /**
     * 实现两个数字的交换
     * 技巧部分，仅适用于 整数 部分
     */
    public static void numberShift() {
        int a = 10;
        int b = 20;

        //传统的两个数字交换
        int c = a;
        a = b ;
        b = c;

        //用 异或 实现的两个数字相交换，无需用新的变量，不占用内存空间，且运算速度还挺快
        a = a ^ b;
        b = a ^ b;  // a^b^b == a
        a = a ^ b;  // a^b^a == b

        // 用加减、或者乘除，实现两个数字的交换
        // 即运算效率没异或快，且可能会溢出
        a = a + b;
        b = a - b; // a+b-b == a
        a = a - b; // a+b-a == b

        a = a * b;
        b = a / b; // a*b/b == a  不会出现小数的
        a = a / b; // a*b/a == a

    }

}
