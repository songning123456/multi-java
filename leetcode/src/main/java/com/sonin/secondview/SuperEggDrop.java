package com.sonin.secondview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2021/1/13 16:06
 */
public class SuperEggDrop {

    private Map<String, Integer> memory = new HashMap<>(2);

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    private int dp(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (memory.containsKey(K + "-" + N)) {
            return memory.get(K + "-" + N);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N + 1; i++) {
            res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
        }
        memory.put(K + "-" + N, res);
        return res;
    }
}
