package com.khanintel.a_stage_1_98.lesson53_TestArray;

import java.util.Arrays;

/**
 */
public class TestArray {

    public static void main(String[] args) {

        int[] intArray = new int[2];
        double doubleArray[] = new double[2];
        String[] stringArray1 = new String[] {"a" , "b", "c"};

        int[] intArray2 = {1, 3, 5};
        int[] intArray3 = new int[] {1, 3, 5};


        // 下面这句就不对了，就是不难指定下面的[3]，
        // 也就是说，要么我跟着初始化的值来创建，要么，我跟着[3]的值来创建，但是我不能跟着两个一起指挥，否则万一冲突了怎么办
        // String[] stringArray2 = new String[3] {"a" , "b", "c"};

        /**
         * 标准矩形的 二维数组
         */
        int[][] array2D = new int[2][2];
        array2D[0][0] = 0;
        array2D[0][1] = 1;
        array2D[1][0] = 2;
        array2D[1][1] = 3;
        for (int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                System.out.println(array2D[i][j]);
            }
        }

        int[][] array2D_copy = Arrays.copyOf(array2D, array2D.length);
        System.out.println("JUSTIN");
        for (int i=0; i<array2D_copy.length; i++) {
            for(int j=0; j<array2D_copy[i].length; j++) {
                System.out.println(array2D_copy[i][j]);
            }
        }


        /**
         * 非矩形 的二维数组 -1
         */
        int[][] array2D_1 = new int[2][];
        array2D_1[0] = new int[] {1, 2, 3};
        array2D_1[1] = new int[] {1, 2, 3, 4, 5};
        //System.out.println(array2D_1[0][1]);

        /**
         * 下面这种二维数组是不可能的，错误的
         */
        //int[][] array2D_x = new int[][2];


        /**
         * 非矩形 的二维数组 -2
         */
        int[][] array2D_2 = {{1,2} , {3,4,5}};

        //下面这句就是语法错误了
        //int[][] array2D_3 = new int[2][2] { {1,2} ,{3,4} };
        int[][] array2D_3 = new int[][] { {1,2} ,{3,4} };


    }




}
