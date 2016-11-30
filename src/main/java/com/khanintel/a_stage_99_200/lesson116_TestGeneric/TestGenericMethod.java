package com.khanintel.a_stage_99_200.lesson116_TestGeneric;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * 泛型方法
 *
 * 泛型方法，可以不存在于泛型类之中
 * 泛型方法，与 是否是static 无关
 *
 * 泛型的声明，在返回值前面
 *
 */
public class TestGenericMethod {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream1 = new FileInputStream("a.txt");
            FileInputStream fileInputStream2 = new FileInputStream("b.txt");
            FileInputStream fileInputStream3 = new FileInputStream("c.txt");
            closeAllIO(fileInputStream1, fileInputStream2, fileInputStream3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        genericMathod1(1);
        genericMathod1("Hello");
        genericMathod1(1.1);

        TestGenericMethod t = new TestGenericMethod();
        int i1 = t.genericMathod2(1);
        double i2 = t.genericMathod2(1.1);
        String i3 = t.genericMathod2("Hello");
        System.out.println( i1 + " " + i2 + " " + i3);

    }


    /**
     * 泛型方法，一个比较全的用法
     * 注意，T... 类似于但不等同于 T[]，有点像 main 函数的 String[] args
     *
     *      T... 可以传
     *      closeAllIO(fileInputStream1);
     *      closeAllIO(fileInputStream1, fileInputStream2, fileInputStream3);
     *
     *      T[] 不可以的
     *
     */
    public static <T extends Closeable> void closeAllIO(T... allCloseable) throws IOException{
    //public static <T extends Closeable> void closeAllIO(T[] allCloseable) {
        for (Closeable c : allCloseable) {
            if (c != null) {
                c.close();
            }
        }
    }


    public static <T extends List> void genericMathod5(T obj) {
        obj.add("Hello");
    }

    /**
     * 泛型方法，没有返回值类型
     * 这个 东西 <T> 在返回值前面
     * @param obj
     * @param <T>
     */
    public static <T> void genericMathod1(T obj) {
        String string = obj.toString();
        System.out.println(string);
    }


    /**
     * 泛型方法，有 泛型 的返回值类型
     * @param obj
     * @param <T>
     * @return
     */
    public <T> T genericMathod2 (T obj) {
        return obj;
    }

    // 下面这两个例子我觉得不好
    //觉得不好是正常的。因为应该这么写 <? extends Parent> <? super Parent>

    /*
    public static <T extends Parent> T genericMathod3 () {
        return (T)(new Son());
    }

    public static <T extends AbstractList> T genericMathod4 () {
        return (T)new ArrayList();
    }
    */

}


class Parent {}
class Son extends Parent {}
