package com.khanintel.a_stage_99_200.lesson129_TestQueue;

/**
 */
public class VerifyMyStack {

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        Integer i = null;
        while (null!=(i = myStack.pop())) {
            System.out.println(i);
        }
    }



}
