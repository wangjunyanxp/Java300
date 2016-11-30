package com.khanintel.a_stage_1_98.lesson37_testThis;

/**
 */
public class TestThis {

    String mString;
    int mInt;

    public TestThis () {

    }

    public TestThis (String mString) {
        this();   //这一句必须放在第一行的位置上
        this.mString = mString;
    }

    public TestThis (String mString, int mInt) {
        this(mString); //这一句必须放在第一行的位置上
        this.mInt = mInt;
    }

    public static void main(String[] args) {
        TestThis a = new TestThis();
        System.out.println(a.toString());
    }


}
