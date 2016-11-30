package com.khanintel.a_stage_99_200.lesson117_TestGeneric_More;

/**
 * 泛型接口的 implements
 */
public class TestGenericImplements {
}

interface Comparator<T> {
    public abstract void compareTo(T obj);
}

class A implements Comparator {
    @Override
    public void compareTo(Object obj) {

    }
}

class B implements Comparator<String> {
    @Override
    public void compareTo(String obj) {

    }
}
