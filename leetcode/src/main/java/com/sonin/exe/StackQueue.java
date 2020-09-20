package com.sonin.exe;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sonin
 * @date 2020/9/20 10:01
 */
public class StackQueue {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] convert = this.nextGreaterElement(nums2);
        Map<Integer, Integer> convertMap = new HashMap<>(2);
        for (int i = 0; i < nums2.length; i++) {
            convertMap.put(nums2[i], convert[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = convertMap.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            ans[i] = s.empty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            ans[i % n] = s.empty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return ans;
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        int[] nums = new int[]{2, 1, 2, 4, 3};
        System.out.println(stackQueue.nextGreaterElement2(nums));
    }
}
