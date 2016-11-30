package com.khanintel.a_stage_99_200.lesson133_TestCollectionSynchronizeReadOnly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 */
public class TestCollectionSyncReadOnly {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        List<String> listSynchronized = Collections.synchronizedList(list1);

        list1.add("a");
        list1.add("b");
        list1.add("c");

        listSynchronized.add("d");
        System.out.println(listSynchronized);

        listSynchronized = new ArrayList<String>();
        listSynchronized.add("New Element 1");
        System.out.println(listSynchronized);


        List<String> listReadOnly = Collections.nCopies(5, "a");
        System.out.println(listReadOnly);
        // 若要修改，将导致 UnsupportedOperationException
        // listReadOnly.add("b");


        Set<String> setSingleTon = Collections.singleton("a");
        List<String> listSingleTon = Collections.singletonList("a");
        System.out.println(setSingleTon);
        System.out.println(listSingleTon);

        // 若要修改，将导致 UnsupportedOperationException
        // setSingleTon.add("b");
        // listSingleTon.add("b");

        List<String> unmodifiableList = Collections.unmodifiableList(list1);
        // 若要修改，将导致 UnsupportedOperationException
        // unmodifiableList.add("d");
        System.out.println(unmodifiableList);


    }

    public static Set<String> setProcess(Set<String> set) {
        if (null == set) {
            return Collections.EMPTY_SET;   // 万一传入的 set 是 null 的时候，我们丢出去一个 空set
                                            // 避免没处理丢出去的时候，有 NullPointerException
        }

        // 一些针对 set 又做了一堆堆的运算

        return set;
    }

}
