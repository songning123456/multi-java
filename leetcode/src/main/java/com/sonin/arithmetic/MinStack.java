package com.sonin.arithmetic;

import java.util.Stack;

/**
 * @author sonin
 * @date 2020/7/18 15:16
 */
public class MinStack {
    private Stack<Integer> curStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        curStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        curStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int val = curStack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return curStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
