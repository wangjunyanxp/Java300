package com.khanintel.a_stage_99_200.lesson128_TestCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections类的常用方法
 *
 * 1. binarySearch，前提，Collection有序
         binarySearch(List<? extends Comparable<? super T>> list, T key)
         使用二分搜索法搜索指定列表，以获得指定对象。
         static <T> int
         binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
         使用二分搜索法搜索指定列表，以获得指定对象。

 * 2. sort
 *
 * 3.
 *
 *
 */
public class TestCollections {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<54; i++){
            list.add(i);
        }
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);



    }

}
