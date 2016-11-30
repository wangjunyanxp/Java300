package com.khanintel.a_stage_1_98.lesson51_TestInnerClass;

/**
 */
public class TestInnerClass {

    public static void main(String[] args) {
        /**
         * 非静态类对象的两种实例化办法
         */
        Face face = new Face();
        Face.Nose nose = face.new Nose();
        nose.breath();

//        Face.Nose nose2 = new Face().new Nose();
//        nose2.breath();

        /**
         * 静态类对象的实例化
         */
        Face.Ear ear = new Face.Ear();
        ear.listen();

    }

}


class Face {

    private int size=1;
    private String shape = "圆脸";

    public static String description = "漂亮";

    /**
     * 这个 Nose，如果需要被访问，则需要是 public，而不是 private 的
     */
    public class Nose {

        private String shape = "圆鼻子";

        public void breath() {
            System.out.println("Nose.breath");
            System.out.println(size);
            System.out.println(shape);
            System.out.println(Face.this.shape);
        }

    }


    public static class Ear {

        public void listen() {
            System.out.println("I am listening");
            System.out.println(description);
        }

    }



}
