package com.khanintel.a_stage_99_200.lesson129_TestQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用 Queue 模拟银行排队取钱的事情
 *
 */
public class TestQueue {

    public static void main(String[] args) {

        //Queue<Request> queue = new LinkedList<>();
        Queue<Request> queue = new ArrayDeque<>();
        // Deque 接口的大小可变数组的实现。数组双端队列没有容量限制；它们可根据需要增加以支持使用。
        // 它们不是线程安全的；在没有外部同步时，它们不支持多个线程的并发访问。
        // 禁止 null 元素。
        // 此类很可能在用作堆栈时快于 Stack，在用作队列时快于 LinkedList。


        // 排队咯
        // 将对象插入到队列里面，对象自带方法的哦
        for (int i=0; i<10; i++){
            final int seqNumber = i;
            queue.offer(new Request() {
                @Override
                public void deposit() {
                    System.out.println("第" + seqNumber + "号，存款数量为" + Math.ceil(Math.random()*10000));
                    //seqNumber，必须是一个 final 的值，如果引入一个变量，那么所有的都指向到同一个变量上了（都是指向最后一个值），没有达到想要区别开的目的
                }
            });
        }


        dealWith(queue);


    }

    // 从队列里面拿出各个元素，并调用元素的方法

    /**
     * 一个通用的、消费 Queue的函数
     * @param queue
     */
    public static void dealWith(Queue<Request> queue) {
        Request req = null;
        while (null != (req=queue.poll())) {
            req.deposit();
        }
        /*
        // 上面写的带有普适性
        // 这里写的没有普适性，因为 queue 不一定就是这么长啊，万一并发处理的时候，还不一定有这些数据
        for(int i=0; i<10; i++) {
            queue.poll().deposit();
        }
         */
    }

}


interface Request {
    //存款
    void deposit();
}
