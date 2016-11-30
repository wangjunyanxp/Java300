package com.khanintel.a_stage_1_98.lesson45_testPolymorphism;

/**
 */
public class TestPolymorphism3 {

    public static void main(String[] args) {

        Animal3 a1 = new Animal3(10);
        Animal3 a2 = new Cat3(20);
        Cat3 a3 = new Cat3(30);

        a1.showAge();
        a2.showAge();
        a3.showAge();
        // 在本例子中，就没有了所谓的 属性的 override，因为都是 private 的 属性，连继承都不会有，谈何而来的“属性”的override重写

        a1.shout();
        a2.shout();
        a3.shout();

    }

}



class Animal3 {
    private int age;

    public Animal3() {}

    public Animal3(int age) {
        this.age = age;
    }

    public void shout() {
        System.out.println("动物叫");
    }

    public void showAge() {
        System.out.println(age);
    }
}

class Cat3 extends Animal3{

    public Cat3 () {}

    public Cat3 (int age) {
        super(age);
    }

    public void shout() {
        System.out.println("喵喵喵");
    }

}

