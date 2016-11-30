package com.khanintel.a_stage_99_200.lesson138_TestCommonsCollections;

import org.apache.commons.collections4.queue.CircularFifoQueue;

/**
 * 一个很有趣的 CircularFifoQueue
 * 有大小限制、自动踢掉老数据
 *
 */
public class TestQueue {

    public static void main(String[] args) {
        CircularFifoQueue<Integer> circularFifoQueue = new CircularFifoQueue(3);
        circularFifoQueue.add(1);
        circularFifoQueue.add(2);
        circularFifoQueue.add(3);
        circularFifoQueue.add(4);
        circularFifoQueue.add(5);
        circularFifoQueue.add(6);

        System.out.println(circularFifoQueue.size());
        System.out.println(circularFifoQueue.peek());
        System.out.println(circularFifoQueue.poll());
        System.out.println(circularFifoQueue.size());

        System.out.println(circularFifoQueue.get(0));
        System.out.println(circularFifoQueue.get(1));


    }

}
