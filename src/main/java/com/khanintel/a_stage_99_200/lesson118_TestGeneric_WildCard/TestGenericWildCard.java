package com.khanintel.a_stage_99_200.lesson118_TestGeneric_WildCard;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的 通配符
 *
 *      ? --> 通配符，类型不确定，用于声明变量、声明形参上
 *
 *      能用在：（即使加上了 extends super 等限制，依旧也只能用在这点场合下了
 *          声明变量
 *          声明形参
 *              这里的变量、形参，并不是指 “ ? variable ”，而是是指一个支持泛型的类的范围 “ List<? extends SomeClass>  ”
 *
 *      不能用在：
 *          创建对象
 *          泛型类、泛型方法、泛型接口的定义上
 *
 *
 * 不要把 ? 和 extends 混淆在一起
 *      ？ --> 指代其他各种类
 *      extends --> 限制泛型类的范围
 *                  既可以 ? extends SomeClass，用在变量声明、形参声明上
 *                  也可以 T extends SomeClass，用在泛型的泛型类、泛型函数、泛型接口上
 *
 *
 */
public class TestGenericWildCard {

    public static void main(String[] args) {

        /**
         * 用于声明变量
         *
         * 说一下这个通配符 ？
         *      我们应用通配符在声明变量、声明形参的时候，并不是 ? variable = new String();
         *      而是，在一个接收泛型的类里面，定义泛型的范围  List<?> list = new ArrayList<String>();
         */
        List<?> list = new ArrayList<String>();
        list = new ArrayList<Integer>();
        list = new ArrayList<Boolean>();


        /**
         * 通配符不能用在创建对象上
         * 其实，泛型，无论是否带通配符，都不能直接创建对象的！
         */
        // list = new ArrayList<?>();
        //new ArrayList<T>();   //只能在泛型类、泛型函数、泛型接口里面有

    }

    /**
     * 用于定义 形参 上
     * @param list
     */
    public static void function_1 (List<?> list){
        System.out.println(list.size());
    }


    // 下面这句，不行
    // 通配符，不能用在 泛型方法 上
    /*
    public static <?> void function_2(? obj){

    }
    */


}


// 通配符，不能用在 泛型类 上，带上 extends super 也不行
/*
class SomeList1 <?> {

}

class SomeList2 <? extends Runnable>{

}

class SomeList3 <? super Runnable> {

}
*/


// 通配符，不能用在 泛型接口 上，带上 extends super 也不行
/*
interface Hello1<?> {

}
interface Hello2<? extends Runnable> {

}
*/


class Fruit {}
class Apple extends Fruit {}
class Pear extends Fruit {}
class FujiApple extends Apple {}

