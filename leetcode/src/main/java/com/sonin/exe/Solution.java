package com.sonin.exe;

import java.util.*;

/**
 * @author sonin
 * @date 2020/9/20 12:45
 */
public class Solution {

    static class MonotonicQueue {

        private Deque<Integer> data;

        MonotonicQueue() {
            data = new ArrayDeque<>();
        }

        void push(int n) {
            while (!data.isEmpty() && data.getLast() < n) {
                data.removeLast();
            }
            data.addLast(n);
        }

        public int max() {
            return data.getFirst();
        }

        void pop(int n) {
            if (!data.isEmpty() && data.getFirst() == n) {
                data.removeFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
