package com.khanintel.a_stage_99_200.lesson129_TestQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 运用 Deque，实现自己的栈
 *
 * 1. 压栈，boolean push
 * 2. 弹栈, E pop()
 * 3. 获取顶部 E peek()
 *
 */
public class MyStack<E> {

    private Deque<E> deque = new ArrayDeque<E>();
    private int cap;

    /**
     * 注意，构造函数，没有上泛型
     *      这个是自己大惊小怪了，泛型类里面的方法，都没必要再写泛型的，包括构造方法
     * @param cap
     */
    public MyStack(int cap) {
        this.cap = cap;
    }

    // 插入，压栈
    public boolean push(E e){
        if (deque.size() == cap) {
            return false;
        }
        return deque.offerLast(e);
    }

    // 移除，弹栈
    public E pop() {
        return deque.pollLast();
    }

    // 检查，获取顶部
    public E peek() {
        return deque.peekLast();
    }

    public int size() {
        return deque.size();
    }




}
