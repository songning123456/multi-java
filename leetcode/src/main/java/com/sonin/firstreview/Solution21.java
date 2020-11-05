package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/5 10:38
 */
public class Solution21 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
