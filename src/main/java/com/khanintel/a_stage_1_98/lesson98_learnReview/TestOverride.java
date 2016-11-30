package com.khanintel.a_stage_1_98.lesson98_learnReview;

/**
 * 旨在验证 继承时重写 的一些规范
 */
public class TestOverride {

    public static void main(String[] args) {

        Father father = new Son();

        System.out.println(father.stringFunction());

        /**
         * 注意，虽然，我们的重写、重写的调用是成功的
         * 但是，返回类型还是以父类的为准，而不是子类的具体返回值类型
         * 如果要用子类的类型，还需要强制转型
         *
         * 这个例子也告诉了我们
         * 在 Exception 的处理的时候，应该也是一样的情况
         */
        String string = (String) father.objectFunction();
        System.out.println(string);



        /**
         * 注意，voidFunction 的 权限不一样
         * 子类public 大于 父类protected
         */
        father.voidFunction();


    }

}



class Father {

    protected void voidFunction () {
        System.out.println("I am your father! --- voidFunction");
    }

    public String stringFunction() {
        return "I am your father! --- stringFunction";
    }

    public Object objectFunction() {
        return new Object();
    }
}

class Son extends Father {

    @Override
    public void voidFunction() {
        System.out.println("I am the son --- voidFunction");
    }


    /**
     * 父类返回值是 void 时，子类不能是 void 之外的返回值
     */
//    @Override
//    public String function() {
//        System.out.println("I am the son");
//        return "I am the son";
//    }


    @Override
    public String stringFunction() {
        return "I am the son --- stringFunction";
    }

    /**
     * 注意，这里的返回值类型与父类不一样，是父类返回值类型的子类。
     * @return
     */
    @Override
    public String objectFunction() {
        return "I am the son --- objectFunction";
    }


}