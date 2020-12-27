package com.sonin.secondview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author sonin
 * @Date 2020/12/27 1:17 下午
 * @Version 1.0
 **/
public class NextGreaterElement {

    private int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int[] convert = this.nextGreaterElement(nums2);
        Map<Integer, Integer> convertMap = new HashMap<>(2);
        for (int i = 0; i < nums2.length; i++) {
            convertMap.put(nums2[i], convert[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = convertMap.get(nums1[i]);
        }
        return res;
    }
}
