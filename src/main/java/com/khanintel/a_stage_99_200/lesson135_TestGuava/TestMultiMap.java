package com.khanintel.a_stage_99_200.lesson135_TestGuava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * MultiMap
 *  可以看作（但实际不是）的数据结构 Map<Key, Collections<E>>
 *  可以做一对多的 Map
 * *******************************************************
 *  这个工具很有用
 *  我们在设计生产管理系统时，要记录每个工作站的累计信息、同时还要关注该站的历史状态，那么采用这个数据结构就是完美中的完美啊
 *
 *  一条记录：
 *  key(工作站）， value（出活的时间）
 *
 *  一个工作站做了多少件，看看 key 的 count
 *  一个工作站的加工历史，拉出每出一件活的时间戳们
 *
 *  完美！！！
 *
 *  也可用于统计每个会员访问网站的时间、次数
 *
 * *******************************************************
 *
 *
 * 之前，做一段文字，一个单词出现次数的统计，用的是 HashMap + 分拣存储思路
 *
 * 现在有 MultiSet，简直是人生开挂啊，但是只能算到次数
 *
 * 但是，真的想既记录次数，又记录第一次出现的时间的话，用MultiMap，每个单词作为key存进来，然后 value 就是这个单词的出现位置。
 * 从 MultiMap 里面导出 MultiSet，算出来出现最多次的，然后再用这个信息，去查找第一次出现的位置
 *
 */
public class TestMultiMap {

    public static void main(String[] args) {
        //A collection that maps keys to values, similar to Map, but in which each key may be associated with multiple values
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("Mr.Wang", "JavaSE");
        multimap.put("Mr.Wang", "CCNP");
        multimap.put("Justin", "CCNA");
        multimap.put("Justin", "CCNP");
        multimap.put("Justin", "CCIE");
        multimap.put("Keli", "C++");

        System.out.println(multimap);
        System.out.println(multimap.size());    //6


        Collection<String> courseWang = multimap.get("Mr.Wang");    //Collection<String>
        Collection<String> courseJustin = multimap.get("Justin");
        Collection<String> courseKeli = multimap.get("Keli");

        System.out.println(courseWang);
        System.out.println(courseKeli);

        Map<String, Collection<String>> collections = multimap.asMap();     // Map<String, Collection<String>>
        System.out.println(collections);
        System.out.println(collections.get("Justin"));  //Collection<String>


        Collection<String> values = multimap.values();  //应该有2个CCNP
        Set<String> keySet =  multimap.keySet();        //不重复
        Multiset<String> keyMultiSet = multimap.keys(); //重复

        System.out.println(values + "\n" + keySet + "\n" + keyMultiSet);

    }
}
