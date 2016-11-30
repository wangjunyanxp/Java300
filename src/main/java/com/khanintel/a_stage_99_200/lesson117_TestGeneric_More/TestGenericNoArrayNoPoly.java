package com.khanintel.a_stage_99_200.lesson117_TestGeneric_More;

import java.util.ArrayList;

/**
 * 泛型
 * 没有多态！没有数组！
 * 没有！
 *      泛型，没有多态！
 *
 *      泛型，没有数组！ （事实证明，还是有数组的）
 *
 *
 * 没有多态
 * 之前看到的多态，是< ? extends X > < ? super XXX >下的可选的项
 *
 */
public class TestGenericNoArrayNoPoly {

    public static void main(String[] args) {

        ArrayList<Fruit> fruits1 = new ArrayList<Fruit>();
        /**
         * 下面这句就不能过编译器
         *
         * 泛型没有多态的解释？
         对于List等collection
         List<Fruit> list = new List<Apple>();
         应该是担心别人丢进来一个Fruit、Pear等等
         */
        //ArrayList<Fruit> fruits2= new ArrayList<Apple>();



        SomeClass<Fruit> c1 = new SomeClass<Fruit>();
        /**
         * 下面这句就不能过编译器
         *
         * 泛型，就是不能有多态！
         *
         * 其实还是有个小疑问的，Fruit属性的所有办法，应该都适用于Apple属性啊
         * 可能是有操作 Fruit 的 private属性/方法时，就可能傻Ⅹ了，所以：
         *      泛型，就是不能有多态！
         */
        //SomeClass<Fruit> c2 = new SomeClass<Apple>();


        //下面这句语法不对
        //ArrayList<String>[] arrayLists = new Aist<String>()[10];

        // 下面这句，其实是把无泛型的赋值给力一个有泛型的
        // assign ArrayList to ArrayList<String>
        ArrayList<String>[] arrayOfArrayList = new ArrayList[10];
        arrayOfArrayList[0] = new ArrayList<>();
        arrayOfArrayList[0].add("0a");
        arrayOfArrayList[9] = new ArrayList<>();
        arrayOfArrayList[9].add("9a");
        //arrayOfArrayList[9].add(1);

        String a = arrayOfArrayList[0].get(0);
        String b = arrayOfArrayList[9].get(0);


        ArrayList[] arrayOfArrayList2 = new ArrayList[10];
        arrayOfArrayList2[0] = new ArrayList<>();
        arrayOfArrayList2[0].add(1);
        arrayOfArrayList2[0].add(false);
        arrayOfArrayList2[0].add("0a");

        arrayOfArrayList2[9] = new ArrayList<>();
        arrayOfArrayList2[9].add("9a");

        //因为泛型被擦除了，所以呢，读取出来的都是Object
        /*
        int aa1 = arrayOfArrayList2[0].get(0);
        boolean aa2 = arrayOfArrayList2[0].get(1);
        String aa3 = arrayOfArrayList2[0].get(2);
        String b2 = arrayOfArrayList2[9].get(0);
        */
        Object obj1 = arrayOfArrayList2[0].get(0);
        Object obj2 = arrayOfArrayList2[0].get(1);



    }


}

class Fruit {
    private String name;
}

class Apple extends Fruit{
    private String name;
}

class SomeClass<T> {
    T t;
}



/*
class MyCollection<T> {
    private T t;

    public MyCollection() {
    }

    public MyCollection(T t) {
        this.t = t;
    }

    public void fun(){
        System.out.println(t);
    }
}

class SubMyClooection<T, T2> extends MyCollection<T>{
    private T2 t2;

    public SubMyClooection() {
    }

    public SubMyClooection(T t) {
        super(t);
    }

    public SubMyClooection(T2 t2) {
        this.t2 = t2;
    }

    public SubMyClooection(T t, T2 t2) {
        super(t);
        this.t2 = t2;
    }
}*/
