package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * 一个 直接可以遍历 Map 的 Iterator
 *
 * mapIterator.next()   获得 Key
 * mapIterator.getKey()     获得 Key
 * mapIterator.getValue()   获得 Value
 *
 * 执行 next 还是有必要的，否则 getKey getValue 拿不到数据 ，会报 Exception
 *      // Exception in thread "main" java.lang.IllegalStateException: getKey() can only be called after next() and before remove()
 *
 * 思路还是和 Java Map 一致的，要有 next()， remove()最多一次。然后就是加上可以遍历的属性，然后再获得 key -- value
 *
 *
 * 省去了 map.keySet.iterator
 *
 */
public class TestMapIterator {

    public static void main(String[] args) {

        IterableMap<String, Integer> integerIterableMap = new HashedMap<>(32);
        integerIterableMap.put("one", 1);
        integerIterableMap.put("two", 2);
        integerIterableMap.put("three", 3);
        integerIterableMap.put("four", 4);
        integerIterableMap.put("five", 5);
        integerIterableMap.put("six", 6);

        MapIterator<String, Integer> mapIterator = integerIterableMap.mapIterator();

        while (mapIterator.hasNext()) {
            System.out.print(mapIterator.next() + "\t");
            System.out.println(mapIterator.getKey() + "\t" + mapIterator.getValue());
        }



    }
}
