package com.khanintel.a_stage_1_98.lesson72_TestException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Exception
 *
 * 区别：
 *     区分 Error 与 Exception
 *     Error，处理办法就是重启
 *
 * Throwable
 *     Error
 *         Unchecked Exception
 *     Exception
 *         Runtime Exception （编译器不会检查出来，运行时可能发生，比如 1/0 ）（是自己程序逻辑不对导致的，都是可以避免的）
 *             Unchecked Exception
 *         Checked Exception (在写代码的时候，就能预先写好 Exception 处理函数的，而且编译器会检查并要求强制处理的）（通常时外部的原因导致的）
 *
 *
 *
 * 优点：
 *     1. 将业务代码、错误处理代码分开
 *     2. 对程序员要求降低，若万一错误处理代码没完全覆盖了所有场景，也有Exception来处理
 *
 * 异常
 *     创建异常对象，丢给 JRE，终止当前函数执行
 *     JRE 捕获异常，并做异常处理
 *
 * 处理异常
 *     方法1：抛出异常。自己不处理异常，丢给调用自己的上级来处理
 *           throws
 *
 *     方法2：捕获异常。开发者在可能出现异常的代码旁边写好捕获、处理函数，发生异常时，JRE 会接收异常
 *           并查找调用发生了异常的函数的调用的栈，从异常处向上回溯，找到异常处理函数并且执行。
 *           try
 *           catch
 *              可能有一个或多个
 *           finally
 *              常用于关闭资源、释放资源
 *
 * 创建异常
 *     创建自定义的异常并且丢出去
 *     throw
 *
 *
 */
public class TestException {

    public static void main(String[] args) {

        FileReader fileReader = null;
        StringBuilder contentInside = new StringBuilder();

        try {
            fileReader = new FileReader("C:\\temp\\1.txt");
            char[] chars = new char[32];
            int len = fileReader.read(chars);
            while (len > 0) {
                contentInside.append(chars, 0, len);
                len = fileReader.read(chars);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(contentInside);

    }


}
