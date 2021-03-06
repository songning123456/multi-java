package com.sonin.firstreview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/6 9:27
 */
public class Solution32 {

    private Map<String, Integer> dpMap = new HashMap<>(2);

    public int superEggDrop(int K, int N) {
        return this.dp(K, N);
    }

    private int dp(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (dpMap.containsKey(K + "-" + N)) {
            return dpMap.get(K + "-" + N);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
        }
        dpMap.put(K + "-" + N, res);
        return res;
    }
}
