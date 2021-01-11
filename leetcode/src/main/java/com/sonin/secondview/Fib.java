package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/7 7:26 下午
 * @Version 1.0
 **/
public class Fib {

    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
