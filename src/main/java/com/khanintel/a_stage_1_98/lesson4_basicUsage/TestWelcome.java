package com.khanintel.a_stage_1_98.lesson4_basicUsage;

/**
 * 这个是我写的很简单的 Java 程序
 * @author 王俊彦
 * @version 1
 * @serial 2
 */

public class TestWelcome {
	public static void main (String[] args) {
		System.out.println("Hello World\n\nKeep coding, Justin !");

        /**
         * 测试 Integer.to***String 的用法
         */
        int a = 10;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toOctalString(a));
		System.out.println(Integer.toHexString(a));
		a = -10;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toOctalString(a));
		System.out.println(Integer.toHexString(a));
		
		char c1 = 'a';
		char c2 = (char)(c1 + 1);
		int i3 = c2 +1;
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(i3);
		
		
		int i1 = 10;
		short s2 = 10;
		//short s3 = i1;
		char c4 = 10;
		//char c5 = i1;
		
		final double PI = 3.14;
		final double PAPI;
		PAPI = 3.14;
		System.out.println(PI);
		System.out.println(PAPI);
		
		short ss1 = 5;
		short ss2 = 5;
		byte bb1 = 5;
		int ii3 = ss1 * ss2;
		
		float f1 = 1111111.1111111F;
		float f2 = 2222222.2222222F;
		float ff3 = f1 * f2 ;
		System.out.println(ff3);
		
		
		int aaa1 = 8;
		int aaa2 = -8;
		System.out.println(aaa1 >> 2);
		System.out.println(aaa1 << 2);
		
		System.out.println(aaa2 >> 2);
		System.out.println(aaa2 << 2);
		
		System.out.println(aaa1 >>> 2);
		System.out.println(aaa2 >>> 2);
		
	}
}



class MyClass {

}