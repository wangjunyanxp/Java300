package com.khanintel.a_stage_99_200.lesson116_TestGeneric;

/**
 * 泛型接口
 * 泛型字母，只能用在方法中，不能用于静态常量里，这个原因和不能有静态类属性一样
 */


/**
 * implements GenericInterface<Integer>
 * 用泛型接口，指定泛型类型为String
 */
public class TestGenericInterface implements GenericInterface<Integer> {

    @Override
    public void compareTo1(Integer integer) {

    }

    @Override
    public Integer compareTo2(Integer integer) {
        return null;
    }

}

/**
 * 泛型接口，这个才是重头戏啊
 * @param <T>
 */

interface GenericInterface<T> {

    /*public static final*/ int MAX = 1024;

    /*public abstract*/ void compareTo1(T t);

    public abstract T compareTo2(T t);

}


/**
 * implements GenericInterface
 * 用泛型接口，没有指定类型
 */
class TestGenericInterface2 implements GenericInterface {
    @Override
    public void compareTo1(Object o) {

    }

    @Override
    public Object compareTo2(Object o) {
        return null;
    }
}

/**
 * implements GenericInterface<String>
 * 用泛型接口，指定泛型类型为String
 */
class TestGenericInterface3 implements GenericInterface<String> {
    @Override
    public void compareTo1(String s) {

    }

    @Override
    public String compareTo2(String s) {
        return null;
    }
}