package com.sonin.firstreview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/5 16:27
 */
public class Solution30 {

    private int[] memory;

    public int jump(int[] nums) {
        int n = nums.length;
        memory = new int[n];
        Arrays.fill(memory, n);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int index) {
        int n = nums.length;
        if (index >= n - 1) {
            return 0;
        }
        if (memory[index] != n) {
            return memory[index];
        }
        int steps = nums[index];
        for (int i = 1; i <= steps; i++) {
            int sub = dp(nums, index + i);
            memory[index] = Math.min(memory[index], sub + 1);
        }
        return memory[index];
    }
}
