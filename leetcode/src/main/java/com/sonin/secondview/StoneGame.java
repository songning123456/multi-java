package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/9 10:16 上午
 * @Version 1.0
 **/
public class StoneGame {

    static class Pair {
        int fir;
        int sec;

        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return res.fir - res.sec > 0;
    }

}
