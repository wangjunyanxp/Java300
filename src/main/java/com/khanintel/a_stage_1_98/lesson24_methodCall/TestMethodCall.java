package com.khanintel.a_stage_1_98.lesson24_methodCall;

import java.util.ArrayList;

/**
 * 目的： 测试方法调用，传递参数为 “对象 object” 的时候，对 original object 的影响
 * @author Justin
 *
 */
public class TestMethodCall {

    /**
     * 简简单单的main方法
     * @param args 没什么用得着的参数
     */
    public static void main(String[] args) {
        /**
         * Part 1: 调用函数，修改 对象 object，用 ArrayList
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");

        System.out.println("### Before Method ##");
        System.out.println(arrayList + "\n");

        System.out.println("### Call Method ##");
        modifyArrayList(arrayList);

        System.out.println("### After Method ##");
        System.out.println(arrayList + "\n");

        /**
         * Part 2: 调用函数，尝试修改 对象 object，用 String
         * 但 事实上， String是不可以修改的，只能创建新的对象
         */
        String s1 = "Hello Justin";
        System.out.println("### Before Method ##");
        System.out.println(s1 + "\n");

        System.out.println("### Call Method ##");
        modifyAndPrint(s1);

        System.out.println("### After Method ##");
        System.out.println(s1 + "\n");
    }

    /**
     * 用于修改ArrayList
     * @param al 一个ArrayList
     */
    public static void modifyArrayList(ArrayList<String> al) {
        al.add("New Value");
        System.out.println(al + "\n");
    }

    /**
     * 测试修改 String object
     * @param s 一个简单的String
     */
    public static void modifyAndPrint(String s) {
        System.out.println(s);
        s = "New Value";
        System.out.println(s + "\n");
    }

}

