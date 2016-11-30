package com.khanintel.a_stage_99_200.lesson117_TestGeneric_More;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * BigClass<MemClass<String>>
 * 嵌套着，来吧~
 *
 */
public class TestGenericNestBetter {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "aa");
        hashMap.put("b", "bb");
        Set<String> set1 = hashMap.keySet();

        Set<Map.Entry<String, String>> set2 = hashMap.entrySet();   // 这里，就是一个泛型的嵌套



        MemClass<Integer> memClass = new MemClass<>();

        BigClass<MemClass<String>> bigClass = new BigClass<>();
        bigClass.setT(new MemClass<>("LALALA"));

        System.out.println(bigClass.getT());


        MemClass<String> memClass2 = bigClass.getT();
        String s = memClass2.getT();


    }


}

class MemClass <T> {
    T t;

    public MemClass() {
    }

    public MemClass(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class BigClass <T> {
    T t;

    public BigClass() {
    }

    public BigClass(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
