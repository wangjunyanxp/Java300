package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.set.PredicatedSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 */
public class TestPredicate {

    public static void main(String[] args) {

        equalPredicate();
        notNullPredicate();
        uniquePredicate();
        myPredicate();

        /**
         * PredicatedXXX.predicatedXXX(容器. predicate)
         * PredicatedList.predicatedList(容器. predicate)
         */
        Predicate notNullPredicate1 = NotNullPredicate.INSTANCE;
        List<Long> list = PredicatedList.predicatedList(new ArrayList<>(), notNullPredicate1);
        Set<Integer> integerSet = PredicatedSet.predicatedSet(new HashSet<>(), notNullPredicate1);

    }

    /**
     * 判断相等
     *      new EqualPredicate<T>("Justin");
     *      EqualPredicate.equalPredicate("Justin");
     *
     *      predicate.evaluate(obj)
     *
     * 还可以自定义 new Predicate<String>() {  public boolean evaluate(String object) {} }
     *
     */
    public static void equalPredicate() {

        System.out.println("TestPredicate.equalPredicate");

        Predicate<String> stringPredicate1 = new EqualPredicate<String>("Justin");
        Predicate<String> stringPredicate2 = EqualPredicate.equalPredicate("Justin");

        boolean flag1 = stringPredicate1.evaluate("justin");
        boolean flag2 = stringPredicate1.evaluate("Justin");
        System.out.println(flag1 + " " + flag2);

        Predicate<String> stringPredicate3 = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.equals("Justin");
            }
        };
        System.out.println(stringPredicate3.evaluate("Hello"));
        System.out.println(stringPredicate3.evaluate("Justin"));

    }


    /**
     * 非空判断
     *      NotNullPredicate.INSTANCE
     *      NotNullPredicate.notNullPredicate()
     *      也可以自定义
     *
     * 有趣的是，Predicate .equals方法 这个还是有些门道的
     *
     */
    public static void notNullPredicate() {
        System.out.println("TestPredicate.notNullPredicate");

        Predicate notNullPredicate1 = NotNullPredicate.INSTANCE;
        Predicate notNullPredicate2 = NotNullPredicate.notNullPredicate();
        Predicate notNullPredicate3 = new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                return object!=null;
            }
        };
        Predicate notNullPredicate4 = object -> object!=null;

        System.out.println(notNullPredicate1.equals(notNullPredicate2));
        System.out.println(notNullPredicate1.equals(notNullPredicate3));    //不清楚原理，但竟然不相等！
        System.out.println(notNullPredicate1.equals(notNullPredicate4));    //不清楚原理，但竟然不相等！
        System.out.println(notNullPredicate3.equals(notNullPredicate4));    //不清楚原理，但竟然不相等！尤其这个很应该相等的

        System.out.println(notNullPredicate1.evaluate(null));
        System.out.println(notNullPredicate2.evaluate(""));
        System.out.println(notNullPredicate3.evaluate(1));
        System.out.println(notNullPredicate4.evaluate(false));

        System.out.println("--------------------------------------------------");

        List<Long> list = PredicatedList.predicatedList(new ArrayList<>(), notNullPredicate1);
        list.add(1L);
        // list.add(null);   // IllegalArgumentException
        System.out.println(list.size());

    }

    /**
     * 不重复 Predicate
     *      UniquePredicate.uniquePredicate()
     */
    public static void uniquePredicate(){

        System.out.println("TestPredicate.uniquePredicate");

        Predicate<String> predicate = UniquePredicate.uniquePredicate();

        List<String> list = PredicatedList.predicatedList(new ArrayList<>(), predicate);
        list.add("a");
        //list.add("a");
        list.add(null);
        //list.add(null);
        System.out.println(list);
    }


    /**
     * 自定义 Predicate
     * 组合 Predicate
     *      PredicateUtils.andPredicate
     *      PredicateUtils.allPredicate
     *
     */
    public static void myPredicate() {

        Predicate<String> predicateCustomized = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.length()>=5;
            }
        };

        Predicate predicateNotNull = NotNullPredicate.INSTANCE;

        Predicate predicateAnd = PredicateUtils.andPredicate(predicateNotNull, predicateCustomized);
        Predicate predicateAll = PredicateUtils.allPredicate(predicateCustomized, predicateNotNull);

        List<String> list = PredicatedList.predicatedList(new ArrayList<>(),predicateAll);
        //list.add(null);
        //list.add("ll");
        list.add("justin");
        System.out.println(list);



    }
}

