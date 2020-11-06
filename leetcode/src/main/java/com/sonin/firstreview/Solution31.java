package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/6 8:39
 */
public class Solution31 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j][0] = 0;
                dp[i][j][1] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = i + j - 1;
                int left = piles[j] + dp[j + 1][k][1];
                int right = piles[k] + dp[j][k - 1][1];
                if (left > right) {
                    dp[j][k][0] = left;
                    dp[j][k][1] = dp[j + 1][k][0];
                } else {
                    dp[j][k][0] = right;
                    dp[j][k][1] = dp[j][k - 1][0];
                }
            }
        }
        int[] res = dp[0][n - 1];
        return res[0] - res[1] > 0;
    }
}
