package com.khanintel.a_stage_1_98.lesson21_for_while;

/**
 */
public class TestForWhile {

    public static void main(String[] args) {

        /**
         * Question 1, 100内的偶数/奇数之和
         */

        int sum = 0;
        for (int i = 0; i <= 100; i+=2) {
            sum += i;
        }
        System.out.println("100内的偶数之和" + sum);


        int i = 1;
        sum = 0;
        while (i <= 100) {
            sum += i;
            i+=2;
        }
        System.out.println("100内的基数之和" + sum);


        int evenSum = 0;
        int oddSum = 0 ;
        for (int i_sxt = 0 ; i_sxt <= 100; i_sxt++) {
            if (0 == i_sxt % 2) {
                evenSum += i_sxt;
            } else {
                oddSum += i_sxt;
            }
        }
        System.out.println("100内的偶数之和" + evenSum);
        System.out.println("100内的基数之和" + oddSum);


        /**
         * Question 2, 1--100之间的能被5整除的数，每行打印 x 个
         */

        System.out.println("1--100之间的能被5整除的数，每行打印3个");
        int numberOfLine = 0;
        for (int j=1; j<100; j++){
            if (0==j%5) {
                if (numberOfLine < 2) {
                    System.out.print(j + " ");
                    numberOfLine++;
                } else {
                    System.out.println(j);
                    numberOfLine = 0;
                }
            }
        }
        if (0 != numberOfLine) {
            System.out.println();
        }

        System.out.println("1--100之间的能被5整除的数，每行打印5个");
        int k = 0;
        numberOfLine = 0;
        while (k<=100) {
            if (numberOfLine < 4) {
                System.out.print(k + " ");
                numberOfLine++;
            } else {
                System.out.println(k);
                numberOfLine = 0;
            }
            k+=5;
        }
        if (0 != numberOfLine) {
            System.out.println();
        }

        int theLastNumber = 0;
        int repeatTimesPerLine = 6 ;
        System.out.println("1--100之间的能被5整除的数，每行打印 " + repeatTimesPerLine + " 个");
        for (int j_sxt = 0; j_sxt < 100; j_sxt += 5) {
            System.out.print(j_sxt + "\t");
            if (0 == j_sxt % (5*repeatTimesPerLine)) {
                System.out.println();
            }
            theLastNumber = j_sxt;
        }
        if (0 != theLastNumber % (5*repeatTimesPerLine)) {
            System.out.println();
        }

        /**
         * Question 3
         */


        sum = 0 ;
        for (int m=1; m<=100; m++) {
            for (int n = 1 ; n <= m; n++) {
                sum += n;
            }
        }
        System.out.println(sum);


        /**
         * Question 4
         */

        sum = 0 ;
        for (int m=1; m<=10; m++) {
            int multiplication = 1;
            for (int n = 1 ; n <= m; n++) {
                multiplication *= n;
            }
            sum += multiplication;
        }
        System.out.println(sum);

        /**
         * Question 5，打印九九乘法表
         */

        for (int x = 1; x <= 9 ; x++) {
            for (int y = 1; y <= x ; y++) {
                System.out.print(y + "*" + x + "=" + x*y + "\t");
            }
            System.out.println();
        }


        /**
         * Question 6, 带标签的continue, break
         */


//            /**
//             * 普通continue，继续自己的小的循环
//             */
//        for (int x = 1; x <= 9 ; x++) {
//            for (int y = 1; y <= 9 ; y++) {
//                if ( y > x ) {
//                    System.out.println();
//                    continue;
//                }
//                System.out.print(y + "*" + x + "=" + x*y + "\t");
//            }
//        }

//            /**
//             * 带标签的continue，继续整个大的循环
//             */
//        myContinuePoint:
//        for (int x = 1; x <= 9 ; x++) {
//            for (int y = 1; y <= 9 ; y++) {
//                if ( y > x ) {
//                    System.out.println();
//                    continue myContinuePoint;
//                }
//                System.out.print(y + "*" + x + "=" + x*y + "\t");
//            }
//        }
//        System.out.println();




//            /**
//             * 普通break，跳出自己内部的子循环
//             */
//        for (int x = 1; x <= 9 ; x++) {
//            for (int y = 1; y <= 9 ; y++) {
//                if ( y > x ) {
//                    System.out.println();
//                    break;
//                }
//                System.out.print(y + "*" + x + "=" + x*y + "\t");
//            }
//        }
//
//
//            /**
//             * 带标签的break，跳出整个循环
//             */
//        myBreakPoint:
//        for (int x = 1; x <= 9 ; x++) {
//            for (int y = 1; y <= 9 ; y++) {
//                if ( y > x ) {
//                    System.out.println();
//                    break myBreakPoint ;
//                }
//                System.out.print(y + "*" + x + "=" + x*y + "\t");
//            }
//        }



    }


}
