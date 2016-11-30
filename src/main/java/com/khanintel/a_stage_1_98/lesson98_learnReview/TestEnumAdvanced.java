package com.khanintel.a_stage_1_98.lesson98_learnReview;

/**
 * Enumerate枚举的高级玩法
 * 例子来自于 Oracle JavaSE Tutorial
 */
public class TestEnumAdvanced {

    public static void main(String[] args) {

        // 构造函数不能用
        // Planet planet = new Planet(1.0 , 2.0);

        /**
         * 好玩的小玩意，调用其他类的 main 函数
         * 1. 创建 arguments 作为参数
         * 2. 调用 main 函数啦
         */
        String[] arguments = new String[] {"175"};
        Planet.main(arguments);

        System.out.println(Planet.MERCURY);

    }

}


enum Planet {
    /**
     * 因为 枚举Enumerate 这个东西，就是一个类
     * 那么，它就可以
     *  1. 有 实例变量 instance variable
     *  2. 有 构造函数
     *  3. 有 函数，包括 main 函数
     *  4. 包括 变量、函数的修饰符 private/public，有板有眼
     */

    /**
     * 这个是 定义，并调用自己的构造函数
     */
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters

    /**
     * 构造函数，默认是 private 的，外部不能调用！
     * 我自己试了，在 Enum 里面，构造函数只能是 private
     * @param mass
     * @param radius
     */
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }
}