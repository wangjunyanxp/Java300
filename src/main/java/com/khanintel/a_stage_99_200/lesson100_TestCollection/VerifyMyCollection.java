package com.khanintel.a_stage_99_200.lesson100_TestCollection;

import java.util.Iterator;

/**
 * 就是测试以下，自己写的 ArrayList、LinkedList（单向、双向链表） 能不能正常的用
 * 测试结果：都能用啦
 */
public class VerifyMyCollection {

    public static void main(String[] args) {

        /**
         * 集合，三选一，都能用 ~
         */
        MyArrayList<String> myCollection = new MyArrayList<>();
        //MyLinkedListBD<String> myCollection = new MyLinkedListBD<>();
        //MyLinkedListUD<String> myCollection = new MyLinkedListUD<>();

        myCollection.add("a");
        myCollection.add("b");
        myCollection.add("c");
        //myCollection.add(1);
        System.out.println(myCollection.size());
        System.out.println(myCollection.get(0));
        //System.out.println(myCollection.get(-1));
        //System.out.println(myCollection.get(3));
        System.out.println(myCollection.indexOf("a"));
        System.out.println(myCollection.indexOf("W"));
        System.out.println(myCollection.remove(0));
        System.out.println(myCollection.remove("b"));
        System.out.println(myCollection.remove("W"));
        System.out.println(myCollection.remove("c"));
        System.out.println(myCollection.size());
        myCollection.add("a");
        myCollection.add("b");
        myCollection.add("c");
        Iterator<String> iterator = myCollection.iterator();
        while(iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
            iterator.remove();
        }
        System.out.println(myCollection.size());
        System.out.println(iterator.hasNext());

        myCollection.add("a");
        myCollection.add("b");
        myCollection.add("c");
        System.out.println(myCollection.remove(0));
        System.out.println(myCollection);

        myCollection.clear();
        myCollection.add("a");
        myCollection.add("b");
        myCollection.add("c");
        System.out.println(myCollection.remove(1));
        System.out.println(myCollection);

        myCollection.clear();
        myCollection.add("a");
        myCollection.add("b");
        myCollection.add("c");
        System.out.println(myCollection.remove(2));
        System.out.println(myCollection);

        myCollection.clear();
        myCollection.add("a");
        System.out.println(myCollection.remove(0));
        System.out.println(myCollection);
        System.out.println(myCollection.size());

        myCollection.clear();
        myCollection.add("aa");
        myCollection.add("bb");
        myCollection.add("cc");
        for (String s:myCollection){
            System.out.println(s);
        }

    }

}
