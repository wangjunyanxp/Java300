package com.khanintel.a_stage_99_200.lesson118_TestGeneric_WildCard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 通配符 + extends
 * 不能用于 数据的添加，一般是数据的读取操作。
 *
 *
 */
public class TestGenericExtendsWildCard {
    public static void main(String[] args) {

        /**
         * 关于范围，可以多态
         */
        ArrayList<? extends Fruit> aL1 = new ArrayList<Fruit>();
        ArrayList<? extends Fruit> aL2 = new ArrayList<Apple>();
        ArrayList<Fruit> aL3 = new ArrayList<>();
        ArrayList<Apple> aL4 = new ArrayList<>();
        ArrayList<?> aL5 = new ArrayList<Apple>();   // ArrayList<?>  就像  ArrayList<? extend Object>
        ArrayList<?> aL6 = new ArrayList<FujiApple>();   // ArrayList<?>  就像 ArrayList<? extend Object>

        verifyGenericWildCard(aL1);
        verifyGenericWildCard(aL2);
        verifyGenericWildCard(aL3);
        verifyGenericWildCard(aL4);
        //verifyGenericWildCard(aL5);       //过不了编译的关
        //verifyGenericWildCard(aL6);       //过不了编译的关


        /**
         *  <? extends Fruit>
         *  不能用在 对 参数的修改上
         *
         *  因为 类型不确定（即使当前确定了未来还可能变更），所以试图修改的行为都可能导致问题
         *  唯一不会导致问题的是增加一个 null 进来
         */
        List<? extends Fruit> list2 = new ArrayList<Apple>();
        list2.add(null);
        /*
        list2.add(new Fruit());
        list2.add(new Apple());
        list2.add(new FujiApple());
        */


    }


    public static void verifyGenericWildCard(List<? extends Fruit> list) {

    }

    public static void testExtendsGeneric(List<? extends Fruit> list) {
        /**
         *  <? extends Fruit>
         *  不能用在 对 形参的修改上，因为不确定究竟是 Fruit、Pear、FujiApple
         */
        //list.add(new Fruit());
        //list.add(new Apple());
    }

}





