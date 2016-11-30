package com.khanintel.a_stage_99_200.lesson130_TestEnumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration，这个是 列举
 *      java.util.Enumeration
 *      public interface Enumeration<E>
 *
 * Enum，这个是 枚举
 *      java.lang.Enum
 *      public abstract class Enum<E extends Enum<E>> extends Object implements Comparable<E>, Serializable
 *
 * 别搞混淆了
 *
 * 新的实现应该优先考虑使用 Iterator 接口而不是 Enumeration 接口。
 * 新的实现应该优先考虑使用 Iterator 接口而不是 Enumeration 接口。
 * 新的实现应该优先考虑使用 Iterator 接口而不是 Enumeration 接口。
 *
 *
 * 现在能整出 Enumeration 的也不多了
 *      Hashtable, Hashtable.elements(), Hashtable.keys(),
 *      Vector, Vector.elements()
 *
 *
 *
 *
 *
 * Enumeration，就看作是 Iterator 迭代器。
 *
 *       实现 Enumeration 接口的对象，它生成一系列元素，一次生成一个。连续调用 nextElement 方法将返回一系列的连续元素。

         例如，要输出 Vector<E> v 的所有元素，可使用以下方法：

         for (Enumeration<E> e = v.elements(); e.hasMoreElements();)
         System.out.println(e.nextElement());这些方法主要通过向量的元素、哈希表的键以及哈希表中的值进行枚举。枚举也用于将输入流指定到 SequenceInputStream 中。

         注：此接口的功能与 Iterator 接口的功能是重复的。
            此外，Iterator 接口添加了一个可选的移除操作，并使用较短的方法名。
            新的实现应该优先考虑使用 Iterator 接口而不是 Enumeration 接口。
 *
 *
 * 里面就 2 方法
         boolean hasMoreElements()
            测试此枚举是否包含更多的元素。
         E nextElement()
            如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
 *
 *
 *
 */
public class TestEnumeration {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        Enumeration<Integer> enumeration = vector.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

    }
}

/**
 * Enumeration， 有一个子类，StringTokenizer
 *  StringTokenizer，类似与 stringObj.split() 方法
 *
 *  1. split() 方法支持 正则表达式
 *  2. split() 是更新、更推荐的方法
 *  3. 想了解 StringTokenizer ，可以看 API，写的很清楚，很容易了解
 *
 *  StringTokenizer 是出于兼容性的原因而被保留的遗留类（虽然在新代码中并不鼓励使用它）。建议所有寻求此功能的人使用 String 的 split 方法或 java.util.regex 包。
 *  StringTokenizer 是出于兼容性的原因而被保留的遗留类（虽然在新代码中并不鼓励使用它）。建议所有寻求此功能的人使用 String 的 split 方法或 java.util.regex 包。
 *  StringTokenizer 是出于兼容性的原因而被保留的遗留类（虽然在新代码中并不鼓励使用它）。建议所有寻求此功能的人使用 String 的 split 方法或 java.util.regex 包。
 *
 */
