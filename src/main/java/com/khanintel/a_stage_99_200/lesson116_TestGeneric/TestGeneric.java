package com.khanintel.a_stage_99_200.lesson116_TestGeneric;

/**
 * 泛型
 *      1. 标签，泛化类型（泛型，就是贴了个标签）
 *      2. 作用：省心、安全  （放东西的时候，安全；拿东西的时候，省心）
 *
 * 泛型的知识点--自定义泛型
 *      1. 泛型类
 *      2. 泛型接口
 *      3. 泛型方法
 *      4. 泛型擦除
 *      5. 泛型嵌套
 *      6. 泛型上下限
 *
 * 泛型
 *      是在一块程序代码可以对多种数据执行相同的功能，代码就是模板，而数据类型则作为参数
 *      主要应用在“集合”上
 *
 * 没有泛型前
 *      1. 类型检查
 *      2. 类型转换，及转化时的异常处理
 *
 * 做泛型之后，数据添加时的自动类型检查，安全
 *
 * 1. 泛型，用大写字母，一般用大家约定好的，万一不够用了，可以加数据，如 T1
 *      T       Type
 *      E       Element
 *      K,V     Key, Value
 *
         E - Element (used extensively by the Java Collections Framework)
         K - Key
         N - Number
         T - Type
         V - Value
         S,U,V etc. - 2nd, 3rd, 4th types
 *
 * 2. 泛型数据不能用于 static 属性
 *      这个还是比较好理解的，因为 静态属性属于类，这个值在方法区，值只有一份，不能有多份
 *      ArrayList.StaticValue，不能即是 Integer，也是 String 类型啊
 *
 * 3. 泛型，指代的都是 引用类型，不是 基本数据类型
 *
 *
 */
public class TestGeneric {

}

/**
 * 总结
 *
 * 泛型 <>
 *      可以是多种类型，类型泛化
 *      安全、省心
 *
 * 自定义泛型
 *      可以带一个或多个泛型
 *
 *      泛型类
 *          class Student<T> {
 *              T obj;
 *          }
 *          <T>只能用在成员变量，不能用在类属性上
 *      泛型接口
 *          interface Comparable<T1, T2> {
 *              public abstract void compareTo (T obj )
 *          }
 *          <T> 不能用在静态常量上
 *      泛型方法
 *          public <T> int method()
 *          public <T> void method(T obj)
 *          public <T> T method()
 *          public <T> T method(T obj)
 *
 */
