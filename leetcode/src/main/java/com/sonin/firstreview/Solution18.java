package com.sonin.firstreview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/5 9:01
 */
public class Solution18 {

    private Map<String, Integer> dpMap = new HashMap<>();

    public int minDistance(String word1, String word2) {
        return dp(word1.toCharArray(), word2.toCharArray(), word1.length() - 1, word2.length() - 1);
    }

    private int dp(char[] word1, char[] word2, int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (dpMap.containsKey(i + "-" + j)) {
            return dpMap.get(i + "-" + j);
        }
        int res;
        if (word1[i] == word2[j]) {
            res = dp(word1, word2, i - 1, j - 1);
        } else {
            res = Math.min(dp(word1, word2, i, j - 1) + 1, Math.min(dp(word1, word2, i - 1, j) + 1, dp(word1, word2, i - 1, j - 1) + 1));
        }
        dpMap.put(i + "-" + j, res);
        return res;
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        solution18.minDistance("horse", "ros");
        System.out.println();
    }
}
