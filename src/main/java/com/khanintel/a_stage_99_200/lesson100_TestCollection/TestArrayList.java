package com.khanintel.a_stage_99_200.lesson100_TestCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 *  Collection在增删查改某个元素的时候，会大量的用到 equals(),  hashCode() 这两个函数，用来判断两个元素是否相等
 *          Justin我在查看 ArrayList 的源代码的时候，发现大量的运用了 equals() 函数。（没有用hashCode）
 *          我个人认为，会大量的调用 equals； 在HashMap HashSet 等场景下才会大量的运用hashCode
 *          如果 equals 一样，那么就会删除掉，即使是两个不同的元素
 *              arrayList.add("A");  arrayList.remove(new String("A")); 这样也会删除掉
 *
 */
public class TestArrayList {

    public static void main(String[] args) {

        /**
         * 推荐用第一种写法，利用“多态” List list = new ArrayList<>();
         * 这样便于后期的更改，比如更换成LinkedList
         *
         * 直接用 ArrayList arrayList 就无法利用多态
         * 用 Collection collection，则无法覆盖ArrayList里面的部分函数，所以不要用太远的父类，避免一些函数这个父类没有
         *
         */
        List list = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        Collection collection = new ArrayList();


        /**
         * 常见的 3个 List
         *  ArrayList
         *      底层是数组
         *      查找，快
         *      插入、删除，慢
         *      线程不安全
         *  Linked List
         *      底层是链表
         *      查找，慢
         *      插入、删除，快
         *      线程不安全
         *  Vector
         *      底层也是用数组实现的
         *      线程安全的ArrayList
         *      性能比ArrayList慢
         */


    }



}
