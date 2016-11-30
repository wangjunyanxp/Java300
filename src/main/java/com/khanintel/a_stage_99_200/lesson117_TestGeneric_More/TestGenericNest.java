package com.khanintel.a_stage_99_200.lesson117_TestGeneric_More;

/**
 */
public class TestGenericNest {

    public static void main(String[] args) {

        MemberClass<String> memberClass = new MemberClass<>();
        memberClass.setT("abc");

        MyClass<Integer, String> myClass = new MyClass<>();
        myClass.setT(100);
        myClass.setMemberClass(new MemberClass<>("Hello"));


        System.out.println(myClass.getMemberClass().getT());

        myClass.setMemberClass(memberClass);
        System.out.println(myClass.getMemberClass().getT());

        MyClass<Integer, Boolean> myClass2 = new MyClass<>(123, new MemberClass<>(true));

    }
}



class MemberClass <T> {
    T t;

    public MemberClass() {
    }

    public MemberClass(T t) {
        this.t = t;
    }

    public void fun1() {
        System.out.println(t);
    }

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}

class MyClass <T, T1> {
    T t;

    MemberClass<T1> memberClass;

    public MyClass() {
    }

    public MyClass(T t, MemberClass<T1> memberClass) {
        this.t = t;
        this.memberClass = memberClass;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setMemberClass(MemberClass<T1> memberClass) {
        this.memberClass = memberClass;
    }

    public T getT() {
        return t;
    }

    public MemberClass<T1> getMemberClass() {
        return memberClass;
    }
}
