package com.khanintel.a_stage_1_98.lesson45_testPolymorphism_MyServelet;

/**
 */
public class HttpServlet {

    public void service() {
        System.out.println("HttpServlet.service");
        doGet();
    }

    public void doGet() {
        System.out.println("HttpServlet.doGet");
    }

}
