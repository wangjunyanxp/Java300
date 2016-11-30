package com.khanintel.a_stage_99_200.lesson125_TestCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * 介绍 Comparable Comparator 的
 *
 *
 *
 1. 对 自定义类 来实现 Comparable 接口
     实体类，implements Comparable
     Array.sort(array);
     Collection.sort(array);

     实现自定义的 CompareTo 方法
     这个自己实现一下
     综合新闻信息的多个属性进行排序，里面比较值得注意的是，就是如何优雅的计算初出 return 值，就是各个 if 语句的嵌套


 2. 实现自己的Comparator
     new Comparator<T> {}
     sort ( collection, comparator )
     自己做一下
     针对商品来做Comparator来进行多种多样的排序，可以做多个Comparator
     注意，Comparator 这个接口，是泛型的，我们可以充分利用这点。
 *
 *
 */
public class TestCompare {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Justin", 50));
        students.add(new Student("Jane", 40));
        students.add(new Student("Joanna", 30));
        students.add(new Student("Jeff", 20));
        students.add(new Student("Jefferson", 50));
        students.add(new Student("John", 10));
        Collections.sort(students);
        System.out.println(students);

        /**
         * 匿名函数版，而且直接使用上了
         */
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int i = o1.name.length() - o2.name.length();
                if (0==i){
                    return o1.score - o2.score;
                }
                return i;
            }
        });
        System.out.println(students);


        /**
         * 利用匿名函数
         */
        Comparator<Student> comparator1 = new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                int i = o1.name.length() - o2.name.length();
                if (0==i){
                    return o1.score - o2.score;
                }
                return i;
            }
        };


        /**
         *  Lambda 版本
         */
        Comparator<Student> comparator2 = (Student o1, Student o2) -> {
            int i = o1.name.length() - o2.name.length();
            if (0==i){
                return o1.score - o2.score;
            }
            return i;
        };


        /**
         * 一个临时用的 class
         */
        class Comparator11<Student> implements Comparator<Student> {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        }


        Collections.sort(students);
        Collections.sort(students,comparator1);
        System.out.println(students);

        Collections.sort(students);
        Collections.sort(students,comparator2);
        System.out.println(students);

    }





}


class Student implements Comparable<Student> {

    String name;
    int score;

    @Override
    public int compareTo(Student o) {
        int i = score - o.score;
        if (0==i) {
            return name.compareTo(o.name);
        }
        return i;

        /*
        int i = score - o.score;
        if (0==i) {
            i = name.compareTo(o.name);
        } else if (xxxxxx) {
            i = **;
        } else if (xxxxxx) {
            i = **;
        } else {
            i = **;
        }
        return i;
        */
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (score != student.score) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + score;
        return result;
    }

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}' + "\n";
    }
}
