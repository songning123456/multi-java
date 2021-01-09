package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/9 9:44 上午
 * @Version 1.0
 **/
public class Jump {

    private int[] memory;

    public int jump(int[] nums) {
        int n = nums.length;
        memory = new int[n];
        for (int i = 0; i < n; i++) {
            memory[i] = n;
        }
        return dp(nums, 0);
    }

    private int dp(int[] nums, int p) {
        int n = nums.length;
        if (p >= n - 1) {
            return 0;
        }
        if (memory[p] != n) {
            return memory[p];
        }
        int steps = nums[p];
        for (int i = 1; i <= steps; i++) {
            int subProblem = dp(nums, p + i);
            memory[p] = Math.min(memory[p], subProblem + 1);
        }
        return memory[p];
    }
}
