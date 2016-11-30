package com.khanintel.a_stage_1_98.lesson53_TestArray;

import java.util.Arrays;

/**
 */
public class TestArray2 {

    public static void main(String[] args) {
        /**
         * 非矩形 的二维数组 -1
         */
        int[][] array2D_1 = new int[2][];
        array2D_1[0] = new int[] {1, 2, 3};
        array2D_1[1] = new int[] {1, 2, 3, 4, 5};
        //System.out.println(array2D_1[0][1]);

        /**
         * Arrays.copyOf
         * 可以用来 copy 一维、二维数组，应该还可以 copy 多维数组
         * 可以 copy 标准矩形、非标准矩形的 多维数组
         */
        int[][] array2D_1_copy = Arrays.copyOf(array2D_1, array2D_1.length);
        System.out.println("JUSTIN");
        for (int i=0; i<array2D_1_copy.length; i++) {
            for(int j=0; j<array2D_1_copy[i].length; j++) {
                System.out.println(array2D_1_copy[i][j]);
            }
        }


        /**
         * System.arraycopy
         * 可以用来 copy 一维、二维数组，应该还可以 copy 多维数组
         * 可以 copy 标准矩形、非标准矩形的 多维数组
         */
        int[][] array2D_1_copy_2 = new int[array2D_1.length][];
        System.arraycopy(array2D_1, 0, array2D_1_copy_2, 0, array2D_1.length);
        System.out.println("JUSTIN");
        for (int i=0; i<array2D_1_copy_2.length; i++) {
            for(int j=0; j<array2D_1_copy_2[i].length; j++) {
                System.out.println(array2D_1_copy_2[i][j]);
            }
        }


        boolean isEqual = Arrays.equals(array2D_1, array2D_1_copy);
        System.out.println(isEqual);


        int[] array1 = new int[] {1,3,5,7,9,2,4,6,8,0};
        int[] array2 = new int[] {0,1,2,3,4,5,6,7,8,9};
        int[] array3 = new int[] {0};
        Arrays.sort(array1);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        int index1 = Arrays.binarySearch(array1, 2);
        int index2 = Arrays.binarySearch(array1, 22);
        System.out.println(index1);
        System.out.println(index2);

        boolean isEqual1 = Arrays.equals(array1, array2);
        boolean isEqual2 = Arrays.equals(array1, array3);
        System.out.println(isEqual1);
        System.out.println(isEqual2);


    }

}
