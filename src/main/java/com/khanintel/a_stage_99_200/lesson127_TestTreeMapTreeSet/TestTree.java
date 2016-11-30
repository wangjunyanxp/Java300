package com.khanintel.a_stage_99_200.lesson127_TestTreeMapTreeSet;


import java.util.TreeSet;

/**
 */
public class TestTree {

    public static void main(String[] args) {

        TreeSet<Student2> students1 = new TreeSet<>();

        TreeSet<Student2> students2 = new TreeSet<>(
                (Student2 o1, Student2 o2) -> {
                    int i = o1.getName().length() - o2.getName().length();
                    if (0==i){
                        return o1.getScore() - o2.getScore();
                    }
                    return i;
                }
        );

        Student2 s1 = new Student2("Justin", 50);
        Student2 s001 = new Student2("JJJJ", 10);
        students1.add(s1);
        students1.add(new Student2("Jane", 40));
        students1.add(new Student2("Joanna", 30));
        students1.add(new Student2("Jeff", 20));
        students1.add(new Student2("Jefferson", 50));
        students1.add(new Student2("John", 10));
        students1.add(s001);

        students2.add(s1);
        students2.add(new Student2("Jane", 40));
        students2.add(new Student2("Joanna", 30));
        students2.add(new Student2("Jeff", 20));
        students2.add(new Student2("Jefferson", 50));
        students2.add(new Student2("John", 10));
        //student2 里面比较的是 名字长度、分数，因为 s001 达到了 Comparator 的相等的标准，所以就不能加进来了
        students2.add(s001);



        System.out.println(students1);
        System.out.println(students2);

        /*
        s1.setName("Jefferson");
        s1.setScore(50);
        */


    }
}


class Student2 implements Comparable<Student2> {

    private final String name;
    private final int score;

    @Override
    public int compareTo(Student2 o) {
        int i = score - o.getScore();
        if (0==i) {
            return name.compareTo(o.getName());
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
        if (!(o instanceof Student2)) return false;

        Student2 student = (Student2) o;

        if (score != student.score) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + score;
        return result;
    }

    public Student2() {
        name = null;
        score = -1;
    }

    public Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}' + "\n";
    }
}




