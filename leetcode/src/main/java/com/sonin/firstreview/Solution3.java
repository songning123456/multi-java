package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/1 13:50
 */
public class Solution3 {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int prev = 1, cur = 1;
        for (int i = 3; i <= N; i++) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }
}
