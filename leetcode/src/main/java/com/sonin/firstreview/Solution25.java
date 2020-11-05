package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/5 13:59
 */
public class Solution25 {

    public int change(int amount, int[] coins) {
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][amount];
    }
}
