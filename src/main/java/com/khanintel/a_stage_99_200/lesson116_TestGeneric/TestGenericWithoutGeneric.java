package com.khanintel.a_stage_99_200.lesson116_TestGeneric;

import java.util.ArrayList;

/**
 * 没有泛型前，数据乱加，没有校验，会有问题
 */
public class TestGenericWithoutGeneric {

    public static void main(String[] args) {

        Student2 student2_1 = new Student2(100);
        Student2 student2_2 = new Student2(99.99);
        Student2 student2_3 = new Student2("优秀");

        ArrayList<Student2> arrayList = new ArrayList<>();
        arrayList.add(student2_1);
        arrayList.add(student2_2);
        arrayList.add(student2_3);

        for (Student2 student2 : arrayList) {
            if (student2.getScore() instanceof Integer) {
                System.out.println(student2.getScore());
            } else if (student2.getScore() instanceof Double) {
                System.out.println(student2.getScore());
            } else if (student2.getScore() instanceof String) {
                System.out.println(student2.getScore());
            } else {
                System.out.println(student2.getScore());
                System.out.println("值类型解析异常");
            }
        }

    }


}


class Student2 {

    private Object score;

    public Student2(Object score) {
        this.score = score;
    }

    public Student2() {
    }

    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }
}
