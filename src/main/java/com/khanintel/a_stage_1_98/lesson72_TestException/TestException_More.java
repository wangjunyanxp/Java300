package com.khanintel.a_stage_1_98.lesson72_TestException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 异常，继续学习
 * 异常处理之 thorws
 *      1. 在 checked exception 产生时，可以不处理，而是把异常丢给上层。
 *      2. 若一个函数可能抛出多种 checked exception 时，则需要在函数声明的首行列出所有 exception，各个异常用逗号"," 隔开。（是在函数处声明，不是在类处声明）
 *      3. 老流氓玩法：在 main 函数里面抛出异常，这样异常由 JRE 自己处理，我们程序不管了，这个属于流氓-老流氓玩法，不要这么做
 *
 * 自己创建 Exception
 *      1. 继承于 Exception 或 Exception的子类
 *      2. 要有两个构造器
 *          一个无参构造器
 *          一个带String详细信息的构造器
 *      3. 捕获异常前，必须有一段代码生成异常对象，并把它抛出。
 *          可以自己做，但往往由 JRE 来实现。
 *          JRE 调用的是 throw 语句。
 *
 * 方法重写中声明异常的原则
 * Override & Exception
 *      1. 原则，老子要包含小子
 *      2. 子类的Exception，必须不能超过父类的范围，是父类异常，或父类异常的子类
 *      3. 父类没异常，子类也不能有异常。
 *
 * 使用时的规矩
 *      1. 避免使用异常处理来代替错误处理，这样会降低程序清晰性，且效率低下
 *              应该用代码逻辑处理的，不要用异常来处理
 *              比如 登录名格式不对，密码不符合要求等等
 *      2. 处理异常不可以代替简单测试，只有在异常情况下使用异常机制
 *              道理同第一点
 *      3. 不要进行小粒度的异常处理，应将整个任务包装在一个 try 语句中
 *      4. 异常往往在高层处理
 *
 * 总结
 *      1. 执行的顺序图，返回值与执行顺序
 *      2. 五个关键字，try catch finally thorws throw
 *      3. 先捕获小异常，再捕获大异常
 *      4. 异常与重写的关系
 *      5. 自定义异常
 *
 *
 */
public class TestException_More {

    public static void main(String[] args) {

    }
    // #######################  论 自己抛异常  ###################################################################################################### //

    public static void someMethod_1() {
        // 某某程序代码，当出现问题需要抛异常时
        try {
            throw new FileNotFoundException("文件不存在");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void someMethod_2() throws FileNotFoundException {
        // 某某程序代码，当出现问题需要抛异常时
        throw new FileNotFoundException("异常信息");
    }

}

// #######################  论 Override & Exception  ###################################################################################################### //

/**
 * 论 Override & Exception
 */
// 父类
class A {
    public void run() throws IOException{

    }
}

/**
 * 可以不抛异常
 */
class B extends A {
    public void run(){

    }
}

/**
 * 可以抛各种 Runtime Exception
 */
class C extends A {
    public void run() throws RuntimeException, ArithmeticException {

    }
}

class D extends A {
    public void run() throws FileNotFoundException {

    }
}

class E extends A {
    public void run() throws FileNotFoundException,ArithmeticException,IOException {

    }
}

/**
 * 不能超过父类范围（不能是父类的父类）
 */
//class F extends A {
//    public void run() throws Exception {
//
//    }
//}

/**
 * 不能超过父类的范围（和父类的异常无关的异常）
 */
//class G extends A {
//    public void run() throws XMLParseException {
//
//    }
//}