package com.sonin.secondview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author sonin
 * @Date 2020/12/27 7:46 下午
 * @Version 1.0
 **/
public class MyStack {

    Queue<Integer> queue;
    int firstElement;

    public MyStack() {
        queue = new ArrayDeque<>();
        firstElement = 0;
    }

    public void push(int x) {
        queue.offer(x);
        firstElement = x;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        firstElement = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return firstElement;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
