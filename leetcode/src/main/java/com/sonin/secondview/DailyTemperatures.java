package com.sonin.secondview;

import java.util.Stack;

/**
 * @Author sonin
 * @Date 2020/12/27 4:32 下午
 * @Version 1.0
 **/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
