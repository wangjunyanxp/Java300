package com.khanintel.a_stage_99_200.lesson135_TestGuava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [非常有趣，非常好玩~~~]
 *
 * 函数式编程
 *      实现了业务类、数据类的解耦
 *
 *      简单探索了下
 *          Java 8 的
 *              stream
 *              filter
 *              map
 *              collect
 *              forEach
 *
 *          Guava 的 函数式编程工具
 *              Collections2.filter + Predicate
 *              Collections2.transform + Function
 *              Functions.compose
 *              Lists（小小的涉及）
 *
 * 函数式编程，解耦做的非常漂亮
 *      业务数据、判断、处理进行了清晰的分类
 *
 *
 *
 */
public class TestFunctionCoding {

    public static void main(String[] args) {

        /**
         *  1. filter 过滤器
         */
        myFilter();

        /**
         *  2. transform 转换
         */
        myTransform();

        /**
         *  3. 组合式函数
         */
        myFunctionCombine();

    }


    /**
     *  1. filter 过滤器
     */
    public static void myFilter(){
        /**
         * Use Java 自带的
         *
         *      stream
         *      filter  过滤器，未来很常用，J2EE里很多
         *      collect
         *      forEach
         *
         */
        List<String> strings1 = Arrays.asList("mom", "dad", "justin", "hello");     // Java
        List<String> strings2 = Lists.newArrayList("mom", "dad", "justin", "hello");    // Guava

        List<String> filteredString = strings1.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString())).collect(Collectors.toList());
        System.out.println(filteredString);
        filteredString.forEach(System.out::println);    //这种写法还是比较特殊的，记住！
        filteredString.forEach(i -> System.out.println(i));

        /**
         * Use Guava
         *      Collections2.filter   过滤器，未来很常用，J2EE里很多
         *      Predicate
         */
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                String reversed = new StringBuilder(input).reverse().toString();
                return input.equals(reversed);
            }
        };
        Collection<String> filteredString_2 = Collections2.filter(strings2, predicate);
        Collection<String> filteredString_3 = Collections2.filter(strings2, s -> s.equals(new StringBuilder(s).reverse().toString()));

        System.out.println(filteredString_2);
        System.out.println(filteredString_3);
        /**
         *  Collections2.filter  == collectionObject.stream().filter(XXX).collect(Collectors.toList())
         */

    }


    /**
     *  2. transform 转换
     *  Collections2.transform + Function
     *
     *  对应于 Java 8，则是 collectionObject.stream().map(XXX).collect(Collectors.toList())
     *      myFinalList = myListToParse.stream()
                             .filter(Objects::nonNull)
                             .map(this::doSomething)
                             .collect(toList());

         Method 1: （一般）     //注意，使用Method 1前，要提前准备 myFinalList
         myListToParse.stream()
                         .filter(elt -> elt != null)
                         .forEach(elt -> myFinalList.add(doSomething(elt)));
         Method 2:（推荐这个）
         myFinalList = myListToParse.stream()
                         .filter(elt -> elt != null)
                         .map(elt -> doSomething(elt))
                         .collect(Collectors.toList());
     *
     *
     */
    public static void myTransform(){
        /**
         */
        //Set<Long> times = Sets.newHashSet();      //Guava Sets
        //由于 Set 是无序的，所以我采用了其他 Collection
        List<Long> times = new ArrayList<>();
        times.add(1000000000000L);
        times.add(2000000000000L);
        times.add(3000000000000L);
        System.out.println(times);

        Collections.sort(times);

        Collection<String> timeStrings1 = Collections2.transform(times, new Function<Long, String>() {
            @Override
            public String apply(Long input) {
                return new SimpleDateFormat("yyyy-MM-dd").format(input);
            }
        });
        Collection<String> timeStrings2 = Collections2.transform(times, input -> new SimpleDateFormat("yyyy-MM-dd").format(input));

        List<String> timeStrings3= times.stream().map(ele -> new SimpleDateFormat("yyyy-MM-dd").format(ele)).collect(Collectors.toList());

        System.out.println(timeStrings1);
        System.out.println(timeStrings2);
        System.out.println(timeStrings3);

    }

    /**
     *  3. 组合式函数
     *
     *      Function f1 = XXX;      // Guava Function
     *      Function f2 = YYY;
     *      Function f3 = Functions.compose(f1, f2)
     *      Collections2.transform(list, f3)
     *
     *
     *      Function f1 = XXX;      // Java Function
     *      Function f2 = YYY;
     *      list.stream().map(f1).map(f2).collect(Collectors.toList());
     *      //想来几个map，就来几个map，随心组合
     */
    public static void myFunctionCombine(){

        List<String> strings = Arrays.asList("aaa", "sssssss", "dddd", "qwqwqw", "qqqqqqqqqqq");

        Function<String, String> function1 = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input.length()>5 ? input.substring(0,5):input;
            }
        };

        Function<String,String> function2 = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input.toUpperCase();
            }
        };
        Function<String, String> functionCombine = Functions.compose(function1, function2);

        Collection<String> processedString2 = Collections2.transform(strings, functionCombine);
        System.out.println(processedString2);

        // Java 8
        // 一个长长的function，包含了整个大function的功能
        List<String> processedString3 = strings.stream().map(s -> {
            if (s.length() > 5){
                s = s.substring(0, 5);
            }
            return s.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println(processedString3);


        java.util.function.Function<String, String> f1 = new java.util.function.Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        java.util.function.Function<String, String> f2 = new java.util.function.Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.substring(0, 1);
            }
        };
        List<String> processedString4 = strings.stream().map(f1).map(f2).collect(Collectors.toList());
        System.out.println(processedString4);



        ///////////////////////////////////////////
        // 这部分不算 组合式函数编程，就是自己玩的
        strings.stream().forEach(s -> {
            if (s.length() > 5){
                s = s.substring(0, 5);
            }
            System.out.println(s.toUpperCase());
        });


    }
}
