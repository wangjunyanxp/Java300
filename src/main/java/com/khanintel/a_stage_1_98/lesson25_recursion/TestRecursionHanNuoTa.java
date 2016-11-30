package com.khanintel.a_stage_1_98.lesson25_recursion;

/**
 * 用迭代的方式，实现“汉诺塔”的搬移计算， 输出搬迁的步数
 *
 * 同时，要标记是把第几层进行了搬迁
 *
 * 在上次的基础上，做了简化，代码量大大缩小
 *
 *
 */
public class TestRecursionHanNuoTa {

    public static void main(String[] args) {

        String source;
        String middle;
        String destination;

        int layer;

        source = "A";
        middle = "B";
        destination = "C";
        layer = 2;

        moveHanoi(layer, source, middle, destination);

    }

    /**
     * 这个版本的函数，是改进版的，代码量很少
     * @param layer
     * @param source
     * @param middle
     * @param destination
     */
    public static void moveHanoi(int layer, String source , String middle, String destination) {
        if (layer == 1) {
            System.out.println(layer + "\t" + source + " ---> " + destination);
        } else {
            moveHanoi(layer-1, source, destination, middle);
            System.out.println(layer + "\t" + source + " ---> " + destination);
            moveHanoi(layer-1, middle, source, destination);
        }
    }

}
