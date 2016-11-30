package com.khanintel.a_stage_1_98.lesson62_TestArraySearch;

/**
 */
public class TestMainArgs {

    public static void main(String[] args) {

        for (int i=0; i<args.length; i++) {
            System.out.println(args[i]);
        }

    }

    /**
     * 1. 用空格区分开各个输入
     * 2， 所谓的 "-s" 等，并没有特殊的含义
     * 3. 所有输入都是 String
     * 4. 参数可以用"" 括住
     * 5. 参数里面引号没有什么意思，一并作为参数使用
     */
    //java TestMainArgs -s 1 "Hello World" "A" "1" ; -w 2 3 a b c hello true ;

    /*

    -s
    1
    Hello World
    A
    1
    ;
    -w
    2
    3
    a
    b
    c
    hello
    true
    ;

     */

}
