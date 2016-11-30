package com.khanintel.a_stage_1_98.lesson25_recursion;

import java.util.Stack;

/**
 */
public class TestRecursion {


    /**
     * Question 1: 用递归实现阶乘
     *
     */
/*    public static void main(String[] args) {
        for (int i=1; i<6; i++) {
            System.out.println(factorial(i));
        }
    }

    public static int factorial(int i) {
//        if (1==i) {
//            return 1;
//        } else {
//            return i * factorial(i - 1);
//        }
        int j = (1==i) ? 1 : ( i * factorial(i-1));
        return j;
    }*/


    /**
     * Question 2: 用迭代的方式，实现“汉诺塔”的搬移计算， 输出搬迁的步数
     *
     * 成功实现，WoW
     *
     * 同时，要标记是把第几层进行了搬迁
     *
     */
    static Stack<Integer> sourceStack       = new Stack();
    static Stack<Integer> middleStack       = new Stack();
    static Stack<Integer> destinationStack  = new Stack();

    public static void main(String[] args) {

        String source = "A" ;
        String middle = "B" ;
        String destination = "C" ;

        initGame(2);
        towerHanoi(2, source, middle, destination);

        System.out.println(sourceStack);
        System.out.println(middleStack);
        System.out.println(destinationStack);
    }

    public static void initGame(int layer) {
        for (int i = layer; i > 0 ; i--) {
            sourceStack.push(i);
        }
    }


    public static void towerHanoi(int layer, String source, String middle, String destination) {
        if ( 1==layer ) {
            moveHanoi(source, destination);
        } else {
            towerHanoi(layer-1, source, destination, middle);
            moveHanoi(source, destination);
            towerHanoi(layer-1, middle, source, destination);
        }
    }


    public static void moveHanoi (String source, String destination) {
        Stack<Integer> tmpSourceStack = null;
        Stack<Integer> tmpDestStack = null;

        switch (source) {
            case ("A"):
                tmpSourceStack = sourceStack;
                break;
            case ("B"):
                tmpSourceStack = middleStack;
                break;
            case ("C"):
                tmpSourceStack = destinationStack;
                break;
        }

        switch (destination) {
            case ("A"):
                tmpDestStack = sourceStack;
                break;
            case ("B"):
                tmpDestStack = middleStack;
                break;
            case ("C"):
                tmpDestStack = destinationStack;
                break;
        }

        int i = tmpSourceStack.pop();
        tmpDestStack.push(i);

        System.out.print(i +"\t");
        System.out.println(source + " ---> " + destination);
    }

    /**
     * Question 3: 用迭代的方式，实现“汉诺塔”的搬移计算，这次，要标记是把第几层进行了搬迁
     *
     *
     */

//    static Stack<Integer> sourceStack = new Stack();
//    static Stack<Integer> middleStack = new Stack();
//    static Stack<Integer> destinationStack = new Stack();
//
//    static String source;
//    static String middle;
//    static String destination;
//
//    static int layer;
//
//
//    public static void main(String[] args) {
//        initGame(3, "A", "B", "C");
//    }
//
//    public static void initGame(int layer, String source, String middle, String destination) {
//        for (int i = layer; i > 0 ; i--) {
//            sourceStack.push(i);
//        }
//        TestRecursion.layer = layer;
//        TestRecursion.source = source;
//        TestRecursion.middle = middle;
//        TestRecursion.destination = destination;
//    }
//
//    public static void towerHanoi(int layer, String source, String middle, String destination) {
//
//        if ( 1==layer ) {
//            int i = sourceStack.pop();
//            System.out.print(i + ":  ");
//            moveHanoi(source, destination);
//            destinationStack.push(i);
//        } else {
//            towerHanoi(layer-1, source, destination, middle);
//
//            int i = sourceStack.pop();
//            System.out.print(i + ":  ");
//            moveHanoi(source, destination);
//            destinationStack.push(i);
//
//            towerHanoi(layer-1, middle, source, destination);
//        }
//    }
//
//    public static void moveHanoi (String source, String destination) {
//        System.out.println(source + " --> " + destination);
//    }




}
