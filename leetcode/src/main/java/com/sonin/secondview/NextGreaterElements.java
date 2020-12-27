package com.sonin.secondview;

import java.util.Stack;

/**
 * @Author sonin
 * @Date 2020/12/27 4:23 下午
 * @Version 1.0
 **/
public class NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return ans;
    }
}
