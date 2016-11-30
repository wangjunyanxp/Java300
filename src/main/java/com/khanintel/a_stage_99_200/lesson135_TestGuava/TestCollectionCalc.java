package com.khanintel.a_stage_99_200.lesson135_TestGuava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * 集合的交集、并集、差集
 *
 * Java 自带的实现
 *      Collection List Set ArrayList 都能用
 * Guava 的实现
 *      Set 能用
 *
 */
public class TestCollectionCalc {

    public static void main(String[] args) {

        List<Integer> list1 = Lists.newArrayList(1, 2, 3, 4, 5);
        List<Integer> list2 = Lists.newArrayList(3, 4, 5, 6, 7, 7);

        /**
         * 一个从一个数组，拷贝出一份一模一样的数组出来的方法。
         * 注意，手法有些不一样
         * 1. 先有size
         * 2. 再有数组 array
         * 3. array 变 collection
         * 4. 用 collection 创建新的 collection
         * 5. 再把数值拷贝过来
         *
         * 没有前几步，直接新创建一个空的进行拷贝的时候，会有 IndexOutOfBoundException
         * 因为这个是给 Collections 用的，不一定是可扩展长度的，所以要根据真实存储的 size 来进行拷贝
         *
         * 注意：在进行两个集合（操作集合和被操作集合）交、并、差操作时，
         * 一定要先将操作集合拷贝一份，
         * 以拷贝的集合作为操作集合来进行运算。
         * 否则，将改变原来操作集合的内容。
         *
         */
        List<Integer> list3 = new ArrayList(Arrays.asList(new Object[list1.size()]));
        Collections.copy(list3, list1);

        List<Integer> list4 = new ArrayList(Arrays.asList(new Object[list1.size()]));
        Collections.copy(list4, list1);

        List<Integer> list5 = new ArrayList(Arrays.asList(new Object[list1.size()]));
        Collections.copy(list5, list1);

        List<Integer> list6 = new ArrayList(Arrays.asList(new Object[list1.size()]));
        Collections.copy(list6, list1);

        /**
         * 交集
         * 并集
         * 差集
         */
        list3.retainAll(list2); //交集

        list4.addAll(list2);    //并集，这个不算是完美的并集，因为有重复的数据。

        list6.removeAll(list2); //并集，也不算是完美的并集，因为只把list6里面的重复数据干掉，但是没有干掉list2的重复数据。
        list6.addAll(list2);    //总能来回折腾掉重复数据，但是想避免重复数据，还是用 set 吧

        list5.removeAll(list2); //差集

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list5);


        ////////////////////////////////////////////////////////
        /**
         * 用 Guava，神清气爽版
         */
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
        Set<Integer> set2 = Sets.newHashSet(3, 4, 5, 6, 7);

        /**
         * 交集、并集、差集
         */
        Set<Integer> set001 = Sets.intersection(set1, set2);
        Set<Integer> set002 = Sets.union(set1, set2);
        Set<Integer> set003 = Sets.difference(set1, set2);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set001);
        System.out.println(set002);
        System.out.println(set003);


    }



}
