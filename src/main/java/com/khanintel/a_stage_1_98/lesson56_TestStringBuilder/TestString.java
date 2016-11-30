package com.khanintel.a_stage_1_98.lesson56_TestStringBuilder;

/**
 */
public class TestString {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Justin");

        sb.append(" is handsome !");
        sb.append(-12345);
        sb.append(true);

        sb.insert(0, "Hello World---");

        System.out.println(sb);

        sb.replace(0,0,"WWW");
        sb.replace(0,6,"WWW");

        System.out.println(sb);

        sb.insert(10,"AHAHA");
        System.out.println(sb);


    }


}
