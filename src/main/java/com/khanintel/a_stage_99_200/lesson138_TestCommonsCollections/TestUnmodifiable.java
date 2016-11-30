package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.list.UnmodifiableList;

import java.util.Collections;
import java.util.List;

/**
 * UnmodifiableXXX.unmodifiableXXX，返回的是一个跟随原数据变更的、不可变的 view
 *
 * 和 Java 自带的 Collections.unmodifiableXXX(xxx) 没差别
 *
 */
public class TestUnmodifiable {

    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList(1, 2, 3);
        List<Integer> listUnmodifiable = UnmodifiableList.unmodifiableList(list);

        list.add(4);
        System.out.println(list);
        System.out.println(listUnmodifiable);

        List<Integer> listUnmodifiable2 = Collections.unmodifiableList(list);

        list.add(5);
        System.out.println(list);
        System.out.println(listUnmodifiable);
        System.out.println(listUnmodifiable2);

    }



}
