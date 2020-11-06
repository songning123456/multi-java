package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/6 10:40
 */
public class Solution33 {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int n = 1;
        while (dp[K][n] < N) {
            for (int k = 1; k <= K; k++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n - 1] + 1;
            }
            if (n == N) {
                return n;
            }
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.superEggDrop(1, 2));
    }
}
