package com.khanintel.a_stage_99_200.lesson118_TestGeneric_WildCard;

/**
 * 无通配符的，泛型 的 泛型类、泛型接口、泛型函数，用 extends
 */
public class TestGenericExtends {

    public static <T extends Fruit > void function_1 (T t) {
    }

    public static void main(String[] args) {

        GenericClass<Fruit> testClass1 = new GenericClass<>();
        GenericClass<Apple> testClass2 = new GenericClass<>();
        GenericClass<FujiApple> testClass3 = new GenericClass<>();


    }

}


class GenericClass <T extends Fruit> {
    public void function_1() {

        GenericClass<Apple> gc1 = new GenericClass<Apple>();
        GenericClass<Fruit> gc2 = new GenericClass<Fruit>();

    }

}

interface GenericInterface <T extends Fruit> {
}

