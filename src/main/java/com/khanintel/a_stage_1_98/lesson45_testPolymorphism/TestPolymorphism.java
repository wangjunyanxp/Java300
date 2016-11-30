package com.khanintel.a_stage_1_98.lesson45_testPolymorphism;

/**
 */
public class TestPolymorphism {

    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println(a.age);
        a.shout();

        Animal b = new Cat();
        System.out.println(b.age);  //这里是 10
        b.shout();

        Animal c = new Dog();
        System.out.println(c.age);  //这里是 10
        c.shout();

        System.out.println("#####################");

        Cat b2 = (Cat) b;
        System.out.println(b2.age);  // 这里是 20
        b2.showAge();

        Dog c2 = (Dog) c;
        System.out.println(c2.age); // 这里是 30
    }
}



class Animal {
    int age = 10;
    public void shout() {
        System.out.println("动物叫");
    }
}

class Cat extends Animal{
    int age = 20;
    //int age = 20;
    // 因为在父类 Animal 的 age 是 public 的，那么其实如果子类不定义的话，也是可以的
    // Cat 继承了 Animal，也就获得了 age 属性
    // Cat 再定义了 age 的话，因为属性没有重写的概念，所以，现在的感觉就是“局部变量”的感觉，同名局部变量 遮盖了 父类的 age 属性

    public void shout() {
        System.out.println("喵喵喵");
    }

    public void showAge() {
        System.out.println(age);
        System.out.println(super.age);
    }

}

class Dog extends Animal{
    int age = 30;
//    int age = 30;
    public void shout() {
        System.out.println("汪汪汪");
    }

}