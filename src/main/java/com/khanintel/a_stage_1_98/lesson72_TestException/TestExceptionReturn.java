package com.khanintel.a_stage_1_98.lesson72_TestException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 旨在了解 Exception 中的返回值
 * 执行顺序
 *      1. 执行 try ，在 try 里面给返回值赋值
 *      2. 若出现 Exception， 则中断 try, 执行 catch, 并由 catch 来给返回值赋值
 *      3. 执行 finally 语句
 *      4. 将在 try 或 catch 语句中的 返回值返回出去
 *      5. 主意：若在 finally 语句中有 return 语句，则会覆盖了 try/catch 中赋值的返回值
 */
public class TestExceptionReturn {

    public static void main(String[] args) {
        String getReturnValue = exceptionReturn();
        System.out.println(getReturnValue);
    }

    private static String exceptionReturn() {
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
            String string = new String(contentInside);
            return string;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "在Exception-1";
        } catch (IOException e) {
            e.printStackTrace();
            return "在Exception-2";
        } finally {
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // return "在Exception-3";   // 不推荐在finally里面有返回值
        }

    }
}


