package com.sonin.secondview;

/**
 * @author sonin
 * @date 2021/1/12 16:03
 */
public class RobII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] numLeft = new int[n - 1];
        int[] numRight = new int[n - 1];
        System.arraycopy(nums, 0, numLeft, 0, n - 2 + 1);
        System.arraycopy(nums, 1, numRight, 0, n - 2 + 1);
        return Math.max(robRange(numLeft), robRange(numRight));
    }

    private int robRange(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }

}
