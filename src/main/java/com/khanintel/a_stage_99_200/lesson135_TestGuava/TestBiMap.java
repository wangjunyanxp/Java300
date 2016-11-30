package com.khanintel.a_stage_99_200.lesson135_TestGuava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Set;

/**
 *
 * 很有用的工具
 * 比如：
 *      用户--邮箱的绑定
 *      用户--手机号的绑定
 *
 * 但是，如果要 用户--邮箱--手机号 的唯一绑定，怎么处理？？
 *
 *
 * BiMap
 *  能 reversed
 *
 *  A bimap (or "bidirectional map") is a map that preserves the uniqueness of its values as well as that of its keys.
 *  This constraint enables bimaps to support an "inverse view",
 *  which is another bimap containing the same entries as this bimap but with reversed keys and values.
 *
 *      	inverse()
 *      	put(K key, V value)
 *      	forcePut(K key, V value)
 *              如果有 key 重复的，则默默地干掉已存的entry
 *      	values()
 *              可以直接拉出啦 value 了，而且是 set 哦
 *
 *
 *  BiMap
 *      Interface BiMap<K,V>
         All Superinterfaces:
             Map<K,V>
         All Known Implementing Classes:
             EnumBiMap, EnumHashBiMap, HashBiMap, ImmutableBiMap
 *
 */
public class TestBiMap {

    public static void main(String[] args) {
        BiMap<String, Integer> biMap = HashBiMap.create();

        biMap.put("one", 1);
        biMap.put("two", 2);
        biMap.put("three", 3);
        biMap.put("four", 4);
        biMap.put("five", 5);

        BiMap<Integer, String> biMapInversed = biMap.inverse();

        System.out.println(biMapInversed);
        System.out.println(biMapInversed.get(1));

        biMap.put("six", 6);
        System.out.println(biMap);
        System.out.println(biMapInversed);

        /**
         * 1. inverse，返回的是一个 view，会不断跟踪着原来的 BiMap 更新的
         * 2. inverse，不是把自己key-value交换，对原来的 BiMap 无修改
         * 3. 也可以对 inverse 掉的Map进行修改
         */

        // 出现 value 重复，会 IllegalArgumentException
        // biMap.put("Some", 1);

        // Key 相同，无所谓的，还是继续放
        biMap.put("one", 111);
        System.out.println(biMap.get("one"));

        // 避免 value 重复的IllegalArgumentException，就强来
        biMap.forcePut("One1One", 111);
        biMap.forcePut("One122", 122);  //即便没重复，也能强来放


        biMapInversed.put(2, "TWO2TWO");
        System.out.println(biMap);

        Set<String> keys = biMap.keySet();
        Set<Integer> values = biMap.values();
        System.out.println(keys + " " + values);

        System.out.println(biMap.inverse().inverse().equals(biMap));        // 无限 inverse

    }


}
