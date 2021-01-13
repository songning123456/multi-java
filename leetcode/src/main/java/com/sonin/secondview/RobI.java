package com.sonin.secondview;

/**
 * @author sonin
 * @date 2021/1/12 15:53
 */
public class RobI {

    /**
     * dp[i] => 从i开始抢劫，最多能抢到的钱dp[i];
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }
}
