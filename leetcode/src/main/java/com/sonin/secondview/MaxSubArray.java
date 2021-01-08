package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/8 7:42 下午
 * @Version 1.0
 **/
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
