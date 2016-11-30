package com.khanintel.a_stage_1_98.lesson59_TestArrayList;

import com.khanintel.a_stage_99_200.lesson100_TestCollection.MyArrayList;

/**
 * 自己简单的实现ArrayList
 */
public class TestArrayList {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(1);
        myArrayList.add(1);
        myArrayList.add(1.0);
        myArrayList.add("Hello");
        myArrayList.add(new Person("Justin"));
        myArrayList.add(new Person("Bieber"));

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(2));


        for (int i = 0; i<myArrayList.size(); i++){
            System.out.println(myArrayList.get(i));
        }

//        System.out.println(myArrayList.get(5));

    }


}

/**
 * 我在lesson 100 里面，写了一个完整的ArrayList
 */





class Person {
    String name;
    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}