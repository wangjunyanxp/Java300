package com.khanintel.TestCode;

/**
 */
public class TestReturnValue {

    public static void main(String[] args) {

        /**
         * a=200
         * 这句话的返回值，就是 200
         */

        int a = 100;

        System.out.println(a=200);
        System.out.println((a=200));

        int b = a = 100;
        System.out.println(a);
        System.out.println(b);

        System.out.println((a=100) == 100);


    }


}
