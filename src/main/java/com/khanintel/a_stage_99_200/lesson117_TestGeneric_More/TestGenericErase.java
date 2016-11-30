package com.khanintel.a_stage_99_200.lesson117_TestGeneric_More;

/**
 * 泛型擦除
 *
 * 默认用 Object
 *
 */
public class TestGenericErase {

    public static void main(String[] args) {

        //下面这句，把泛型擦除了
        Student s1 = new Student();
        s1.setScore(100);
        verifyTypeInteger(s1);

        s1.setScore("Hello");
        // !-0 //
        //下面这两句，与接下来注释的两句，揭示出了泛型覆盖 与 泛型Object 的区别
        // 如果是泛型覆盖，则虽然这个泛型可以看作是 Object，但也能被套用在其他泛型上，如 Student<Integer> 、Student<String> 等
        // 而且这种套用是不完全可靠的（可能丢异常），因为我们的例子里，放了一个String，但是也能被 调用 Student<Integer> 的函数所使用
        verifyTypeInteger(s1);
        verifyTypeString(s1);

        Student<Object> s2 = new Student<>();
        s2.setScore(100);
        // 而明显标注为 Object 的泛型，则失去了套用在 Student<Integer> 、Student<String> 等函数的可能性，直接在编译阶段就被拒绝了
        // !-1 //verifyTypeInteger(s2);
        // !-2 //verifyTypeString(s2);
        // 总结一句话，就是泛型擦除，但依旧保留了可能性，可以作为任何泛型Student<WhateverType>


        Student<Integer> s3 = new Student<>(100);

    }


    public static void verifyTypeInteger(Student<Integer> student) {
        //System.out.println(student.getScore().getClass().toString());
        System.out.println(student.getScore());
    }

    public static void verifyTypeString(Student<String> student) {
        //System.out.println(student.getScore().getClass().toString());
        System.out.println(student.getScore());
    }





}

class Student <T> {
    T score;

    public Student() {
    }

    public Student(T score) {
        this.score = score;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

}


