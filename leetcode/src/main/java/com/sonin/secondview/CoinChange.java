package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/7 7:34 下午
 * @Version 1.0
 **/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);

            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
