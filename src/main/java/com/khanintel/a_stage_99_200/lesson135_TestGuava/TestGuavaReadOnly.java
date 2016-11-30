package com.khanintel.a_stage_99_200.lesson135_TestGuava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *  用 Guava，搞 Read Only 的 Collection
 *
 *  单独拷贝了一份、不会修改的、Collection
 *
 *  （实现思想与 Java Collections, Apache Commons Collections 不一样）
 *
 */
public class TestGuavaReadOnly {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // Collections.unmodifiableList，搞出来的List 不能修改，但是能够通过原来的List进行修改
        // Collections.unmodifiableList，返回的是一个 ReadOnly 的 View
        List<String> listReadOnly = Collections.unmodifiableList(list);

        // ImmutableList.copyOf(); 返回的是一个快照，一个不可修改的快照，数据都另外存储了一份
        List<String> immutableList = ImmutableList.copyOf(list);

        list.add("d");
        System.out.println(list);
        System.out.println(listReadOnly);   //还是会随着老数组一起变
        System.out.println(immutableList);  //不会变化


    }



}
