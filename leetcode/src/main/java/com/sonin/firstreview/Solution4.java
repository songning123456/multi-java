package com.sonin.firstreview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/1 14:07
 */
public class Solution4 {

    private Map<Integer, Integer> dpMap = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    private int dp(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        if (dpMap.containsKey(n)) {
            return dpMap.get(n);
        }
        int res = Integer.MAX_VALUE;
        for (int item : arr) {
            int subProblem = dp(arr, n - item);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        dpMap.put(n, res);
        return res;
    }
}
