package com.khanintel.a_stage_99_200.lesson100_TestCollection;

import java.util.Comparator;
import java.util.List;

/**
 * 本来想实现自己的 Collections.sort()  Arrays.sort()
 * 但依赖项有些大，先不做了
 *
 *
 * 可以看看里面的泛型，写的很精致
 *
 * 2. 写一个自己实现的、带有泛型的，Array.sort()，以及Collection.sort()
        小小细节，注意 instanceof Comparable
        public static <T extends Comparable<T>> void sort(T[] array)
        注意这里的 <T extends Comparable<T>> ， 不是 <T extends Comparable> ，啊哈！

        更加优雅的写法：public static <T extends Comparable<? super T>> void sort(T[] array)
        Comparator<? super T>
 *
 */
public class MyCollections {


    /**
     * 实现了半截
     *      就看看泛型吧，其他的就算了
     *
     * @param list
     * @param c
     * @param <T>
     */
    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        Object[] array = list.toArray();  // 注意，是因为不能 new T[] {} ，所以不能直接返回一个 T[]。
                                          // list.toArray(T[] a) 返回的是一个 T[]
    }


    /**
     * 下面是 官方源代码
     */

    /**
     *  Collections.sort()
     */
    /*
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        list.sort(c);
    }
    default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }
    */


    /**
     * Arrays.sort()
     */
    /*
    public static void sort(Object[] a) {
        if (LegacyMergeSort.userRequested)
            legacyMergeSort(a);
        else
            ComparableTimSort.sort(a, 0, a.length, null, 0, 0);
    }

    //To be removed in a future release.
    private static void legacyMergeSort(Object[] a) {
        Object[] aux = a.clone();
        mergeSort(aux, a, 0, a.length, 0);
    }
    */

}
