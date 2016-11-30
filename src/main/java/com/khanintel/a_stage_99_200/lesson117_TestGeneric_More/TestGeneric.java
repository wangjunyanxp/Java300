package com.khanintel.a_stage_99_200.lesson117_TestGeneric_More;

/**
 * 泛型的继承
 * 泛型的擦除
 *
 */
public class TestGeneric {
}

/**
 * 总结
 * 1. 泛型的继承
 *
 *      泛型的保留：泛型子类
 *          全部保留
 *          部分保留
 *      泛型的按需替换实现：实现了父类的泛型的子类，可以是、也可以不是泛型子类（可以新增泛型啦）
 *          全部替换
 *          擦除
 *
 *      泛型父类的属性、方法，还是保留在子类中
 *
 *
 *
 *
 * 2. 泛型的擦除
 *      泛型的使用（ new Student() ）、继承（ class C4 extends Father ）、实现，没有指定具体类型时，则表现的像Object，但是拥有变成其他泛型的可能性
 *
 *
 */
