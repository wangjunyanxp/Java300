package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.set.PredicatedSet;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * 在 Collection 加数据之前，就对数据进行校验的方式
 *
 *  Predicate + PredicatedXXX
 *
 *  PredicatedList<Integer> predicatedList = PredicatedList.predicatedList(new ArrayList<>(), predicate);
 *
 */
public class TestPredicatedCollection {

    public static void main(String[] args) {

        Predicate predicate = NotNullPredicate.notNullPredicate();

        PredicatedList<Integer> predicatedList = PredicatedList.predicatedList(new ArrayList<>(), predicate);

        predicatedList.add(1);
        predicatedList.add(2);
        predicatedList.add(3);
        System.out.println(predicatedList);

        // Exception in thread "main" java.lang.IllegalArgumentException: Cannot add Object 'null' -
        //      Predicate 'org.apache.commons.collections4.functors.NotNullPredicate@610455d6' rejected it

        // predicatedList.add(null);

        Set<Integer> set = Sets.newHashSet(1, 2, 3);
        PredicatedSet<Integer> predicatedSet = PredicatedSet.predicatedSet(set, predicate);
        System.out.println(predicatedSet);

    }

}
