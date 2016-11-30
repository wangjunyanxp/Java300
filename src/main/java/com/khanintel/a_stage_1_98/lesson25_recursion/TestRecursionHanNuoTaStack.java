package com.khanintel.a_stage_1_98.lesson25_recursion;

import java.util.Stack;

/**
 * 想用 Stack栈 的方式来做
 */
public class TestRecursionHanNuoTaStack {

    public static Stack<Integer> sourceStack = new Stack<>();
    public static Stack<Integer> middleStack = new Stack<>();
    public static Stack<Integer> destinationStack = new Stack<>();
    public static int steps;

    public static void main(String[] args) {

        String source;
        String middle;
        String destination;

        int layer;

        source = "A";
        middle = "B";
        destination = "C";
        layer = 20;

        for (int i=layer; i>0; i--) {
            sourceStack.push(i);
        }

        System.out.println(sourceStack);
        moveHanoiV2(layer, source, middle, destination);
        System.out.println("总共执行了" + steps + "步！");
        /**
         * 顺便提一下 1 ，【数学】会发现层数和总步数，成2的 n 次幂的关系
         * 顺便提一下 2 ，【计算机】反复的进行迭代调用，并没有导致 stackoverflow 的错误，我们在执行了 20层汉诺塔的操作也没发现类似的问题
         */

    }

    /**
     * 这个版本，按照之前的想法，用 Stack 来对数据进行追踪
     * @param layer
     * @param source
     * @param middle
     * @param destination
     */
    public static void moveHanoiV2(int layer, String source , String middle, String destination) {

        Stack<Integer> tmpSourceStack = null;
        Stack<Integer> tmpDestStack = null;

        switch (source) {
            //主意，这里直接与"A" "B" "C" 进行对比，是不合理的，但是switch的例子里，必须使用常量进行对比
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

        if (layer == 1) {
            int bottomElement = tmpSourceStack.pop();
            tmpDestStack.push(bottomElement);
            System.out.println(bottomElement + "\t" + source + " ---> " + destination);
            /**
             * 如果想知道每一次移动之后，各个栈的状态，则可以这么操作
             * 打印-Part-1
             * 需要主意的是，这个打印，只能放在这个位置来打印，不能放在整个 if-else 之外
             */
            System.out.println(sourceStack + "\n" + middleStack + "\n" + destinationStack);
            System.out.println("-------------------------------------------");
            steps++;

        } else {
            moveHanoiV2(layer-1, source, destination, middle);

            int bottomElement = tmpSourceStack.pop();
            tmpDestStack.push(bottomElement);
            System.out.println(bottomElement + "\t" + source + " ---> " + destination);
            /**
             * 如果想知道每一次移动之后，各个栈的状态，则可以这么操作
             * 打印-Part-2
             * 需要主意的是，这个打印，只能放在这个位置来打印，不能放在整个 if-else 之外
             */
            System.out.println(sourceStack + "\n" + middleStack + "\n" + destinationStack);
            System.out.println("-------------------------------------------");
            steps++;

            moveHanoiV2(layer-1, middle, source, destination);
        }



    }


}

