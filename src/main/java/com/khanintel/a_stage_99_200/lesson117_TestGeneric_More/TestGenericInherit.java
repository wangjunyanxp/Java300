package com.khanintel.a_stage_99_200.lesson117_TestGeneric_More;

/**
 * 泛型、继承
 *
 * 父类使用了泛型时，子类有2种处理办法
 *
 *      方法1：保留父类的泛型。留给子类的子类来实现
 *          1.a，全部保留下来
 *          1.b，部分保留下来
 *
 *      方法2：不保留父类的泛型。把 T1 T2 替换掉，根据自己的需要来指定 T1 T2 具体对应的类
 *          2.a. 替换成具体类型
 *          2.b. 没有具体类型，直接做泛型的擦除，类似但不等同于 Object
 *
 */
public class TestGenericInherit
{
}


/**
 * 注意，T1  T2，一个用在属性，一个用在方法
 *
 * 注意，method1，method2 这两个方法不一样，在子类重写的时候，也不一样！！！
 * 问题：method1，method2 这两个方法的写法，导致了有什么不同呢？
 *
 * 子类重写父类的方法，函数泛型类型 由 extends 的父类而定
 * 子类使用父类的变量，变量的泛型 由 extends 的父类而定
 * 上面这两句写的不好，这么说，“父类擦除或执行类型时，子类则要服从父类的设置”
 *
 * 这个规则，不仅是继承父类时的规矩，其实也是实现接口时的规则
 *
 * 再提一个别的事
        泛型类，一般都作为 抽象父类。
        一般继承抽象父类，并采取组合、聚合、关联、依赖的方式来使用
 *
 * @param <T1>
 * @param <T2>
 */
abstract class Father<T1, T2> {
    T1 age;

    /**
     *
     * @param name
     */
    public abstract void method1(T2 name);

    /**
     * 下面这个就是一个 不好的案例，是在 泛型A类 里面，搞了一个 泛型B类 的方法
     * 虽然名字一样，但事实上，是覆盖了泛型类A的类型
     * @param name
     * @param <T2>
     */
    public abstract <T2> void method2(T2 name);
}




class C1<T1, T2> extends Father<T1, T2> {

    @Override
    public void method1(T2 name) {
        // age 类型没指定，所以还是类型 T1
        T1 i = this.age;
    }

    /**
     * 就是因为我们是 是在 泛型A类 里面，搞了一个 泛型B类 的方法，所以在IDE重写的时候，自动换了一个泛型类
     * @param name
     * @param <T21>
     */
    @Override
    public <T21> void method2(T21 name) {

    }
}
//下面这句也行，调换 T1 T2 的位置
//class C1<T2, T1> extends Father<T1, T2> {}
// C1 和下面这句可以看作一样的，无论 T1 \ T3 等等，都是个符号而已
//class C1<T3, T4> extends Father<T3, T4> {}



class C2<T2> extends Father<Integer, T2> {
    @Override
    public void method1(T2 name) {
        //age，被子类覆盖成 Integer 了
        Integer i = this.age;
    }

    @Override
    public <T21> void method2(T21 name) {

    }
}

class C3 extends Father<Integer, String> {
    @Override
    public void method1(String name) {
        //age，被子类覆盖成 Integer 了
        //Integer i = this.age;
    }

    @Override
    public <T2> void method2(T2 name) {

    }
}


class C4 extends Father {
    @Override
    public void method1(Object name) {
        //age，被子类覆盖成 Object 了
        //Object i = this.age;
    }

    /**
     * 这里，不知道为何，泛型被擦除了，应该是相当于这个泛型类没泛型了，都给我变成Object啦
     *
     * 总之一句话，在 泛型A类 里面，搞了一个 泛型B类 的方法，这种愚蠢的行为，还是不要做了
     * @param name
     */
    @Override
    public void method2(Object name) {

    }
}
// C4 类似于下面这个
//class C4<C,D> extends Father<Object, Object> {}

// 当然，子类继承了父类，除了父类的泛型，自己也可以增加泛型，但是不能减少掉父类的泛型
/*
    若父类存在泛型 A B C，子类在继承的时候，也要有 泛型A B C（当然，这些类可以被指明为具体的类，或者还是依旧泛型）。
    除了子类有泛型 A B C 之外，还可以有泛型 D E F G 等等
 */
//class C1<T3, T4, A, B> extends Father<T3, T4> {}
//class C2<T2, C,D > extends Father<Integer, T2> {}
//class C3<A, B> extends Father<Integer, String> {}
//class C4<A> extends Father<Object, Object> {}
