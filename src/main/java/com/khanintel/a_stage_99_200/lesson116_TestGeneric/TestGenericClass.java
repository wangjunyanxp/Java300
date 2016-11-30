package com.khanintel.a_stage_99_200.lesson116_TestGeneric;

/**
 * 泛型类
 *
 */
public class TestGenericClass {

    public static void main(String[] args) {
        Student<Integer> student1 = new Student<>(100);
        int score_int = student1.getScore();

        Student<String> student2 = new Student<>();
        student2.setScore("优秀");
        String score_string = student2.getScore();

        Student<Double> student3 = new Student<>(99.99);
        double score_double = student3.getScore();

        System.out.println(score_int);
        System.out.println(score_string);
        System.out.println(score_double);

    }

}


class Student<T> {

    private T score;

    public Student() {
    }

    public Student(T score) {
        this.score = score;
    }

    /**
     * 注意这里的 返回值
     * 对了，这个 set / get 方法，都是泛型方法
     * @return
     */
    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }
}
