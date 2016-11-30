package com.khanintel.a_stage_1_98.lesson27_testScanner;

import java.util.Scanner;

/**
 * 测试Scanner的使用。
 * BTW: 从这个开始，规范化文档。
 * @author Justin
 * @version 1
 *
 */
public class TestScanner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input something");

        String s = scanner.next();
        System.out.println("User input");
        System.out.println(s);

        System.out.println("两数相加的结果是：" + add(scanner));

    }

    /**
     *
     * @param scanner 用户输入System.in
     * @return 两个输入的和
     */
    public static int add(Scanner scanner) {
        System.out.println("Input number 1");
        int a = scanner.nextInt();
        System.out.println("Input number 2");
        int b = scanner.nextInt();

        return a+b;

    }

}
