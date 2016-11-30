package com.khanintel.a_stage_99_200.lesson116_TestGeneric;

/**
 */
public class TestGenericAnother {

    public static void main(String[] args) {
        GenericClass<String> gClass = new GenericClass<>();
        gClass.variable = "a";
        gClass.function_1("b");
        //下面这句，因为泛型不匹配而失败
        // gClass.function_1(1);

        // 注意下面这2句，尤其是后面这两句，发现类的泛型被泛型方法的泛型覆盖了，可以接收各种类型了
        gClass.function_3("c");
        gClass.function_3(5);
        gClass.function_3(true);

        gClass.function_4();

        // /////////////////

        NormalClass nClass = new NormalClass();
        nClass.function_02("a");
        nClass.function_02(1);
        nClass.function_02(true);

        NormalClass.function_01("a");
        NormalClass.function_01(1);
        NormalClass.function_01(true);

    }

}

class GenericClass<T> {
    T variable;

    /**
     * 这个类，是泛型类
     * 这里用到的，会一并沿袭泛型类的 T
     * @param t
     */
    public void function_1(T t){
        System.out.println(t);
    }

    /**
     * 下面这个方法，不能是 static 的
     * 因为这个 T 来自于 泛型类，没有把类泛型指明之前，函数中使用泛型 T肯定是不可能的
     * @param t
     */
    /*
    public static void function_2(T t){
        System.out.println(t);
    }
    */

    /**
     * 这个泛型方法，其实是摆脱了泛型类的T，是一个自己独立的 T
     * 就像是局部变量一样的，掩盖了泛型类的 T，相当于一个 T1 或其他
     * @param t
     * @param <T>
     */
    public <T> void function_3(T t){
        System.out.println(t);
    }

    public void function_4(){
        System.out.println(variable);
    }


}

class NormalClass {

    /**
     * 注意，非泛型类里面的泛型方法，可以是 static，也可以是 非static 的
     *
     * PS：其实泛型方法就应该属于非泛型类，因为我需要一个泛型，而我的类没有提供给我这个泛型，所以才有了泛型接口
     *
     * 可以是 static，也可以是 非static 的。
     * 是否static这个讲述很正确。因为自身的类没有泛型，那么我函数里面用到的泛型和这个类没半毛钱关系。所以我可以是static，也可以不是
     *
     * @param t
     * @param <T>
     */
    public static <T> void function_01(T t) {
        System.out.println(t.toString());
    }

    public <T> void function_02(T t) {
        System.out.println(t.toString());
    }


    /**
     * 在没有泛型类的情况下，若没有声明方法是泛型方法，直接使用泛型的话，编译器根本就不会认这个泛型
     * @param t
     */
    /*
    public void function_03(T t) {
        System.out.println(t.toString());
    }
    */


}
