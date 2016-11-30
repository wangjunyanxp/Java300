package com.khanintel.a_stage_1_98.lesson45_testPolymorphism;

/**
 */
public class TestPolymorphism2 {

    public static void main(String[] args) {
        Animal2 a = new Animal2(10);
        System.out.println(a.age);
        a.shout();

        Animal2 b = new Cat2(20);
        System.out.println(b.age);
        b.shout();

        Animal2 c = new Dog2(30);
        System.out.println(c.age);
        c.shout();

        System.out.println("#####################");

        Cat2 b2 = (Cat2) b;
        System.out.println(b2.age);

        Dog2 c2 = (Dog2) c;
        System.out.println(c2.age);

    }
}



class Animal2 {
    int age;
    public Animal2() {

    }
    public Animal2(int age){
        this.age = age;
    }
    public void shout() {
        System.out.println("动物叫");
    }
}

class Cat2 extends Animal2{
    int age;
    public Cat2(int age){
        this.age = age;
    }
    public void shout() {
        System.out.println("喵喵喵");
    }

}

class Dog2 extends Animal2{
    int age;
    public Dog2(int age){
        this.age = age;
    }
    public void shout() {
        System.out.println("汪汪汪");
    }
}