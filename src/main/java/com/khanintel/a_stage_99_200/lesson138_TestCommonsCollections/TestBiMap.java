package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualLinkedHashBidiMap;

import java.util.Set;

/**
 * BidiMap
    Interface BidiMap<K,V>

    Type Parameters:
        K - the type of the keys in the map
        V - the type of the values in the map
    All Superinterfaces:
        Get<K,V>, IterableGet<K,V>, IterableMap<K,V>, Map<K,V>, Put<K,V>
    All Known Subinterfaces:
        OrderedBidiMap<K,V>, SortedBidiMap<K,V>
    All Known Implementing Classes:
        AbstractBidiMapDecorator, AbstractDualBidiMap, AbstractOrderedBidiMapDecorator, AbstractSortedBidiMapDecorator,
        DualHashBidiMap, DualLinkedHashBidiMap, DualTreeBidiMap, TreeBidiMap,
        UnmodifiableBidiMap, UnmodifiableOrderedBidiMap, UnmodifiableSortedBidiMap
 *
 * BidiMap的经典使用案例
 *  Key--Value，标准的一一对应关系
 *  用户名--手机号，用户名--邮箱
 *
 */
public class TestBiMap {

    public static void main(String[] args) {
        /**
         * inverseBidiMap()，Inverse出来的，也是一个 view，两个 map 数据是相通的
         */
        BidiMap<String, Integer> bidiMap = new DualLinkedHashBidiMap<>();
        //bidiMap = new DualLinkedHashBidiMap<>();
        //bidiMap = new DualHashBidiMap<>();
        //bidiMap = new DualTreeBidiMap<>();
        bidiMap.put("one", 1);
        bidiMap.put("two", 2);
        bidiMap.put("three", 3);
        bidiMap.put("four", 4);
        bidiMap.put("five", 5);

        BidiMap<Integer, String> inversedBidiMap = bidiMap.inverseBidiMap();

        System.out.println(bidiMap);
        System.out.println(inversedBidiMap);

        inversedBidiMap.put(6, "six");

        System.out.println(bidiMap);
        System.out.println(inversedBidiMap);

        System.out.println(bidiMap.get("six"));
        System.out.println(inversedBidiMap.put(6, "SIX"));

        System.out.println(bidiMap);
        System.out.println(inversedBidiMap);

        /**
         * 有几个有趣的接口
         */
        MapIterator<String,Integer> mapIterator = bidiMap.mapIterator();
        while (mapIterator.hasNext()) {
            System.out.println(mapIterator.next() + " " + mapIterator.getValue());
        }

        Set<Integer> values = bidiMap.values();
        System.out.println(values);

    }

}
