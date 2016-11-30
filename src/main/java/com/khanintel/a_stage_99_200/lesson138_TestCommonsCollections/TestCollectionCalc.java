package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Set;

/**
 * 集合的 交集、并集、差集
 *
 * 好处就是，不修改老数据，直接返回一个新的 Collection，这点和 Guava 像，但比 Guava 强一点
 *
 * Apache Commons Collections 的 交集、并集、差集的运算，是在 collection 范围内的支持
 *
 * Apache Commons Collections， 是最合适的 计算 交集、并集、差集 的工具
 *
 */
public class TestCollectionCalc {
    public static void main(String[] args) {

        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
        Set<Integer> set2 = Sets.newHashSet(3, 4, 5, 6, 7);

        Collection<Integer> union = CollectionUtils.union(set1, set2);
        Collection<Integer> jiaoJi1 = CollectionUtils.retainAll(set1, set2);
        Collection<Integer> jiaoJi2 = CollectionUtils.intersection(set1, set2);
        Collection<Integer> chaJi = CollectionUtils.subtract(set1, set2);

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(union);
        System.out.println(jiaoJi1);
        System.out.println(jiaoJi2);
        System.out.println(chaJi);





    }
}
