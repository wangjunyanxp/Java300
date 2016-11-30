package com.khanintel.a_stage_1_98.lesson72_TestException;

/**
 */
public class TestException_My {

    public static void main(String[] args) {

        try {
            exceptionThrow();
        } catch (MyException e) {
            e.printStackTrace();
        }


    }

    /**
     * 函数爆出 Exception
     * @throws MyException
     */
    public static void exceptionThrow() throws MyException {
        throw new MyException("异常");
    }

}

/**
 * 自定义异常
 */
class MyException extends Exception {

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

}
