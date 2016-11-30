package com.khanintel.a_stage_1_98.lesson62_TestArraySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 冒泡算法、二分法算法的实施
 */
public class TestArraySearch {

    public static void main(String[] args) {
        int[] array = new int[] {6,2,9,4,7,3,5,2,0,1,8,5,6,2,22,11,22};
        System.out.println(Arrays.toString(array));
        /*
        myArraySort(array, true);
        System.out.println(Arrays.toString(array));
        System.out.println();

        */
        /**
         * 调用冒泡算法
         *//*

        myArraySort(array, true);
        System.out.println(Arrays.toString(array));

        //这个设计的不是很完美，调用排序的时候，是返回一个新的Array，还是直接把原有的给修改掉？
        myArraySort(array, false);
        System.out.println(Arrays.toString(array));

        // 这个设计的不是很完美，万一我传进来是一个降序的，然后用升序查找呢？要不要对数组进行重新排序呢？
        System.out.println(myArrayBinarySearch(array, 6, false));
        System.out.println(myArrayBinarySearch(array, 66, false));


        //以下，是测试 朴素版的ArraySortUnique
        int[] uniqueInts1 = myArraySortUnique_V1_basic(array);
        System.out.println(Arrays.toString(uniqueInts1));

        int[] uniqueInts2 = myArraySortUnique_V1_basic(array, false);
        System.out.println(Arrays.toString(uniqueInts2));
*/

        System.out.println(Arrays.toString(array));

        int[] noDuplicates = IntStream.of(array).distinct().toArray();
        Arrays.sort(noDuplicates);
        System.out.println(Arrays.toString(noDuplicates));

    }


    /**
     * 使用冒泡算法，对数组进行排序，支持升序、降序
     * @param array
     * @param isAscending
     */
    public static void myArraySort (int[] array, boolean isAscending) {
        /**
         * 冒泡算法
         */
        if (isAscending) {
            for (int i = array.length-2; i >= 1; i--) {
                for (int j = 0 ; j <= i; j++) {
                    if (array[j] > array[j+1]) {
                        int tmp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = tmp;
                    }
                }
            }
        } else {
            for (int i = array.length-2; i >= 1; i--) {
                for (int j = 0 ; j <= i; j++) {
                    if (array[j] < array[j+1]) {
                        int tmp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = tmp;
                    }
                }
            }
        }
    }

    public static void myArraySort (int[] array) {
        myArraySort(array, true);
    }

    /**
     * 对数组进行 Unique 与 Sort
     * 朴素版，先转化成 Set，再转换成 Array，再进行排序
     * 中间涉及到了 int[] Integer[] 之间的互转，都是手工实现的
     * 用 Java 8 可以更加完美的实现
     * @param array
     * @param isAscending
     * @return
     */
    public static int[] myArraySortUnique_V1_basic(int[] array, boolean isAscending) {
        /**
         * 思路 1，先做排序，然后从头查找相同的项（一对或者更多相连的项），然后根据这个 index 来拷贝数组，也需要自己实现拷贝工具
         * 思路 2，先转化成 Set，再转换成 Array，再进行排序
         * 思路 3，使用 Java8 里面的各种特性
         */

        Integer[] integers = new Integer[array.length];
        for (int i=0; i<array.length; i++) {
            integers[i] = array[i];
        }
        Set<Integer> set = new HashSet<>(Arrays.asList(integers));
        Integer[] uniqueIntegerArray = set.toArray(new Integer[]{});
        int[] uniqueInts = new int[uniqueIntegerArray.length];
        for (int i=0; i<uniqueIntegerArray.length; i++) {
            uniqueInts[i] = uniqueIntegerArray[i];
        }
        myArraySort(uniqueInts, isAscending);
        return uniqueInts;
    }

    public static int[] myArraySortUnique_V1_basic(int[] array) {
        return myArraySortUnique_V1_basic(array, true);
    }

//    public static int[] myArraySortUnique_V2_Java8(int[] array) {
//        int[] noDuplicates = IntStream.of(array).distinct().toArray();
//        Arrays.sort(noDuplicates);
//        return noDuplicates;
//    }

    /**
     * 对已经是升序、降序排列的数组，进行二分法查询
     * 也适用于队列里面有重复出现的数据的情况
     * @param array
     * @param target
     * @param isAscending
     * @return
     */
    public static int myArrayBinarySearch (int[] array, int target, boolean isAscending, int startPoint, int endPoint) {

        /**
         * startPoint, endPoint 这两个参数可以由用户传进来，进行更加详细的查找
         * 没有对 startPoint, endPoint 这两个参数进行参数检查
         */
        //int startPoint = 0;
        //int endPoint = array.length - 1;
        int middle;

        int indexFound = -1;

        while (startPoint <= endPoint) {

            middle = (startPoint + endPoint) /2 ;
            //System.out.println(startPoint + "\t" + middle + "\t" + endPoint);

            if (array[middle] > target) {
                if (isAscending) {
                    endPoint = middle - 1;
                } else {
                    startPoint = middle + 1;
                }
            } else if (array[middle] < target) {
                if (isAscending) {
                    startPoint = middle + 1;
                } else {
                    endPoint = middle - 1;
                }
            } else {
                indexFound = middle;
                //获得第一个出现该元素的地方
                for (int i = indexFound; i>0; i--) {
                    //if (array[i-1] == target) {
                    if (array[i-1] == array[i]) {
                        indexFound = i-1;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return indexFound;
    }

    /**
     * 默认数组是升序排序的
     * @param array
     * @param target
     * @return
     */
    public static int myArrayBinarySearch (int[] array, int target) {
        return myArrayBinarySearch(array, target, true, 0, array.length - 1);
    }

    public static int myArrayBinarySearch (int[] array, int target, boolean isAscending ) {
        return myArrayBinarySearch(array, target, isAscending, 0, array.length - 1);
    }



}
