package com.sonin.secondview;

import java.util.*;

/**
 * @Author sonin
 * @Date 2020/12/27 5:31 下午
 * @Version 1.0
 **/
public class MaxSlidingWindow {

    class MonotonicQueue {
        private Deque<Integer> deque = new ArrayDeque<>();

        public void push(int n) {
            while (!deque.isEmpty() && deque.getLast() < n) {
                deque.removeLast();
            }
            deque.addLast(n);
        }

        public int max() {
            return deque.getFirst();
        }

        public void pop(int n) {
            if (!deque.isEmpty() && deque.getFirst() == n) {
                deque.removeFirst();
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
