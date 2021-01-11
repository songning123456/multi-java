package com.sonin.secondview;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author sonin
 * @Date 2021/1/3 1:00 下午
 * @Version 1.0
 **/
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int item : nums) {
            queue.offer(item);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        FindKthLargest findKthLargest = new FindKthLargest();
        int result = findKthLargest.findKthLargest(nums, k);
        System.out.println(result);
    }
}
