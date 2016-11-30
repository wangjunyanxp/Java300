package com.khanintel.a_stage_1_98.lesson41_testSuper;

/**
 */
public class TestSuper {

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.show();
        son.show();
    }
}


class Father {
    public int value;

    public void show() {
        value = 100;
        System.out.println("Father " + value);
    }
}


class Son extends Father{
    public int value; //其实不存在变量的Override重写的，重写仅针对于函数

    public void show() {
        value = 200;
        super.show();
        System.out.println("Son " + value);
        System.out.println(super.value);
    }

}
