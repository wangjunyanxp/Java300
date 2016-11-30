package com.khanintel.a_stage_99_200.lesson118_TestGeneric_WildCard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 通配符，用 super 的场景
 *      注意，不带通配符的泛型，不支持用 super
 *      一句话： super 仅仅适用于通配符的场景下
 *
 * 可以添加数据，只能添加自己、或者子类的对象
 *
 *
 */
public class TestGenericSuperWildcard {

    public static void main(String[] args) {

        // 没泛型，支持多态
        List<Fruit> list = new ArrayList<>();
        list.add(new Apple());
        list.add(new FujiApple());


        /**
         * 定义变量，支持多态
         *
         */
        List<? super Pear> list3 = new ArrayList<Pear>();
        List<? super Apple> list4 = new ArrayList<Fruit>();
        List<? super Apple> list5 = new ArrayList<Apple>();
        List<? super Fruit> list6 = new ArrayList<Fruit>();
        list3.add(new Pear());
        list5.add(new Apple());
        list5.add(new FujiApple());

        List<?> list7 = new ArrayList<Apple>();
        //list7.add(new Apple());  // ? 这个范围太广了

        function_1(list4);
        function_1(list5);
        function_1(list6);
        //function_1(list7); // list7 “?” 这个范围太广了

    }


    /**
     * 形参
     */
    public static void function_1(List<? super Apple> list){
        list.add(new Apple());
        list.add(new FujiApple());
        //list.add(new Fruit());  //这句不行
    }




    /**
     * 不带通配符的泛型，不支持用 super
     *
     *      我的认为，之所以不支持用 super，是担心 hold 不住，
     *      里面各种类丢进来，函数、类、接口这些都不一定好写。最极端情况，万一丢了一个 Object 进来，怎么办？
     */
//    public static <T super Apple> void function_1() {
//
//    }

}

/**
 * 不带通配符的泛型，不支持用 super
 * @param <T>
 */
//class SomeClass<T super Apple> {
//
//}
/**
 * 不带通配符的泛型，不支持用 super
 * @param <T>
 */
//interface SomeInterface<T super Apple>{
//}
