package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.*;

import java.util.Iterator;
import java.util.List;

/**
 * 使用 Apache Commons Collections 的 迭代器 Iterator
 *
 * 其实就是带着形形色色的 Predicate 的 Iterator
 *
 * （这个 Predicate，是针对 Collection 本身数据元素的 Predicate ）
 * （还有一个做的比较狠的，就是从数组这边生成迭代器，思路应该是 array --> arrayList view --> arrayList view Iterator，没有走 Predicate，而是直接在数据层面做的了）
 *
 */
public class TestIterator {

    public static void main(String[] args) {

        //去重迭代器
        uniqueIterator();
        System.out.println("--------------------");

        //自定义 Iterator
        customizedIterator();
        System.out.println("--------------------");

        //无限循环 Loop 的 迭代器
        loopIterator();
        System.out.println("--------------------");

        //数组迭代器
        arrayIterator();
        System.out.println("--------------------");


    }

    /**
     * 去重迭代器  unique Iterator
     */
    public static void uniqueIterator() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 3, 2, 1);
        UniqueFilterIterator<Integer> uniqueFilterIterator = new UniqueFilterIterator<>(list.iterator());
        while (uniqueFilterIterator.hasNext()) {
            System.out.println(uniqueFilterIterator.next());
        }
    }

    /**
     * new FilterIterator<>(list.iterator(), predicate);
     *
     * 自定义 Iterator，包括 CommonsCollections 自带的 Iterator，本质上都是在已有的Iterator上面带上一个 predicate，里面限定好特定的规则
     *
     */
    public static void customizedIterator() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 3, 2, 1);
        Predicate<Integer> predicate = input -> input > 2;
        FilterIterator<Integer> filterIterator = new FilterIterator<>(list.iterator(), predicate);
        while (filterIterator.hasNext()) {
            System.out.println(filterIterator.next());
        }
    }

    /**
     * LoopIterator，无限循环 Loop 的 迭代器
     */
    public static void loopIterator() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        /**
         * 有两个可以用的工具
         *      LoopingIterator
         *      LoopingListIterator
         */
        LoopingIterator<Integer> loopingIterator = new LoopingIterator<>(list);
        LoopingListIterator<Integer> loopingListIterator = new LoopingListIterator<>(list);

        for (int i = 0; i< 20; i++) {
            System.out.print(loopingIterator.next() + "\t");
        }
        System.out.println();

        for (int i = 0; i< 20; i++) {
            System.out.print(loopingListIterator.next() + "\t");
        }
        System.out.println();

    }


    /**
     * 数组迭代器，硬生生的在 数组Array 上面，搞一个 迭代器
     * （不用好端端的 for (int i=0; i<array.lengh; i++) 这一套了）
     *
     * 可能的原因，就是要让程序（迭代器+处理部分的程序），更加普适于各种数据结构，不改变业务逻辑代码的同时，对数据类型的支持大幅增加
     */
    public static void arrayIterator() {
        int[] arrays = new int[] {1, 2, 3, 4, 5};
        Iterator<Integer> integerIterator1 = new ArrayListIterator<Integer>(arrays);
        while (integerIterator1.hasNext()) {
            System.out.print(integerIterator1.next() + "\t");
        }
        System.out.println();

        /**
         * 带有 startIndex, endIndex 的 ArrayListIterator
         * （长度是 endIndex - startIndex， 不包含 endIndex的数据）
         */
        Iterator<Integer> integerIterator2 = new ArrayListIterator<Integer>(arrays, 1, 3);
        while (integerIterator2.hasNext()) {
            System.out.print(integerIterator2.next() + "\t");
        }
        System.out.println();

    }




}
