package com.khanintel.a_stage_99_200.lesson135_TestGuava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import java.util.Set;

/**
 *
 * 看作是一个 Bag ，可以一直向里面丢东西
 * A collection that supports order-independent equality, like Set, but may have duplicate elements.
 * A multiset is also sometimes called a bag.
 * ----------------------------
 *
 * 之前，做一段文字，一个单词出现次数的统计，用的是 HashMap + 分拣存储思路
 *
 * 现在有 MultiSet，简直是人生开挂啊，但是只能算到次数
 *
 * 但是，真的想既记录次数，又记录第一次出现的时间的话，用MultiMap，每个单词作为key存进来，然后 value 就是这个单词的出现位置。
 * 从 MultiMap 里面导出 MultiSet，算出来出现最多次的，然后再用这个信息，去查找第一次出现的位置
 *
 *
 *  可用于统计每个会员访问网站的次数（要想看访问的时间的话，还是需要 MultiMap)
 *
 */
public class TestMultiSet {

    public static void main(String[] args) {
        //A collection that maps keys to values, similar to Map, but in which each key may be associated with multiple values
        Multimap<String, String> multimap = ArrayListMultimap.create();

        // A multiset is also sometimes called a bag.
        Multiset<String> multiset = HashMultiset.create();


        String string = "Hello is me dear my friend every day and night i love you darling only you just only you justin justin justin i love you";
        String[] wordArray = string.split(" ");
        for (int i=0; i<wordArray.length; i++){
            multiset.add(wordArray[i]);
        }

        Set<String> stringSet = multiset.elementSet();
        for (String s: stringSet) {
            System.out.println(s + " repeated times: " + multiset.count(s));
        }
        System.out.println(multiset);

        Set<Multiset.Entry<String>> entrySet = multiset.entrySet();
        for (Multiset.Entry<String> i : entrySet) {
            System.out.println(i.getElement()  + " --> " +  i.getCount());
        }

        multiset.add("WWW", 101);
        multiset.setCount("justin", 200);
        multiset.remove("WWW", 99);
        multiset.remove("Hello");

        System.out.println(multiset);


    }
}
