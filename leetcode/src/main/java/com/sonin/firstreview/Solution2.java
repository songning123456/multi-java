package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/1 13:42
 */
public class Solution2 {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.fib(2);
    }
}
