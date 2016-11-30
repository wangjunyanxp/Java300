package com.khanintel.a_stage_99_200.lesson132_TestStrongSoftWeakPhantom;

import java.lang.ref.WeakReference;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.WeakHashMap;

/**
 */
public class TestStrongSoftWeak {

    public static void main(String[] args) {
        strongReference();
        System.out.println("------------------------------");

        weakReference();
        System.out.println("------------------------------");

        testWeakHashMap();
        System.out.println("------------------------------");

        testEnumMap();
        System.out.println("------------------------------");

        testIdentityHashMap();
        System.out.println("------------------------------");

    }

    public static void strongReference() {
        String s1 = "Hello World Justin";
        WeakReference<String> weakReference = new WeakReference<String>(s1);

        System.out.println("Before");
        System.out.println(s1);
        System.out.println(weakReference.get());

        s1 = null;
        System.gc();
        System.runFinalization();

        System.out.println("After GC");
        System.out.println(s1);
        System.out.println(weakReference.get());
    }

    public static void weakReference() {
        String s1 = new String("Hello World Justin");  //就是这行有差别
        WeakReference<String> weakReference = new WeakReference<String>(s1);

        System.out.println("Before");
        System.out.println(s1);
        System.out.println(weakReference.get());

        s1 = null;
        System.gc();
        System.runFinalization();

        System.out.println("After GC");
        System.out.println(s1);
        System.out.println(weakReference.get());
    }

    public static void testWeakHashMap() {
        /**
         * WeakHashMap,应用场景
         *      在存放巨大的数据,但又担心内存消耗过高,可以用这个工具
         */
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();

        //键,是常量,字符串常量,不会被GC回收掉
        weakHashMap.put("Key-1", "Value-1");
        weakHashMap.put("Key-2", "Value-2");

        //对象,丢进来的时候,就是被当作是弱键
        weakHashMap.put(new String("Key-3"), new String("Value-3"));
        weakHashMap.put(new String("Key-4"), new String("Value-4"));

        System.out.println(weakHashMap.size());

        System.gc();
        System.runFinalization();

        System.out.println(weakHashMap.size());

    }

    public static void testEnumMap() {
        /**
         * 注意看 构造函数
         *
         *  new EnumMap<Season, Integer>(Season.class)
         *
         */
        EnumMap<Season, Integer> seasonIntegerEnumMap = new EnumMap<Season, Integer>(Season.class);
        seasonIntegerEnumMap.put(Season.SPRING, 1);
        seasonIntegerEnumMap.put(Season.SUMMER, 2);
        seasonIntegerEnumMap.put(Season.AUTUMN, 3);
        seasonIntegerEnumMap.put(Season.WINTER, 4);
        System.out.println(seasonIntegerEnumMap.get(Season.SUMMER));
    }

    public static void testIdentityHashMap(){
        IdentityHashMap<String, Integer> integerIdentityHashMap = new IdentityHashMap<>();
        integerIdentityHashMap.put("a", 1);
        integerIdentityHashMap.put("a", 2);
        integerIdentityHashMap.put(new String("a"), 3);
        integerIdentityHashMap.put(new String("a"), 4);
        System.out.println(integerIdentityHashMap.get("a"));
        System.out.println(integerIdentityHashMap.get(new String("a")));
        System.out.println(integerIdentityHashMap.size());
    }



}

enum Season{
    SPRING, SUMMER, AUTUMN, WINTER
}
