package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.TreeBag;

import java.util.Iterator;
import java.util.Set;

/**
 * 感觉，有些像 Guava 的 MulitSet，或者这么说，就是一模一样的
 *
 * Bag
 *
 *      Defines a collection that counts the number of times an object appears in the collection.
 *
 *      Suppose you have a Bag that contains {a, a, b, c}.
 *      Calling getCount(Object) on a would return 2, while calling uniqueSet() would return {a, b, c}.
 *
 *
 *      All Known Implementing Classes:
            AbstractBagDecorator, AbstractMapBag, AbstractSortedBagDecorator,
            CollectionBag, CollectionSortedBag,
            HashBag, PredicatedBag, PredicatedSortedBag, SynchronizedBag, SynchronizedSortedBag,
            TransformedBag, TransformedSortedBag, TreeBag, UnmodifiableBag, UnmodifiableSortedBag


 *      NOTE: This interface violates the Collection contract.
 *      The behavior specified in many of these methods is not the same as the behavior specified by Collection.
 *      The noncompliant methods are clearly marked with "(Violation)".
 *      Exercise caution when using a bag as a Collection.
 *
 *      This violation resulted from the original specification of this interface.
 *      In an ideal world, the interface would be changed to fix the problems,
 *      however it has been decided to maintain backwards compatibility instead.
 *
 *
 */
public class TestBag {

    public static void main(String[] args) {

        Bag<String> bag = new TreeBag<>();
        String string = "Hello is me dear my friend every day and night i love you darling only you just only you justin justin justin i love you";
        String[] wordArray = string.split(" ");
        for (int i=0; i<wordArray.length; i++){
            bag.add(wordArray[i]);
        }
        bag.add("Justin", 10);
        // 负数，不顶用哦
        // bag.add("Justin", -100);
        bag.remove("Justin", 1);
        bag.remove("only");
        System.out.println(bag);

        Iterator<String> stringIterator = bag.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());  //因为是 TreeMap, 所以数据是自然有顺序的哦
        }

        Set<String> stringSet = bag.uniqueSet();
        System.out.println(stringSet);

        System.out.println(bag.getCount("Justin"));



    }


}
