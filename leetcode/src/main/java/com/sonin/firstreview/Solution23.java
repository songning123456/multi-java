package com.sonin.firstreview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/5 11:18
 */
public class Solution23 {

    private Map<String, Integer> dpMap = new HashMap<>(2);

    public int longestCommonSubsequence(String text1, String text2) {
        return dp(text1.toCharArray(), text2.toCharArray(), text1.length() - 1, text2.length() - 1);
    }

    private int dp(char[] str1, char[] str2, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (dpMap.containsKey(i + "-" + j)) {
            return dpMap.get(i + "-" + j);
        }
        int res;
        if (str1[i] == str2[j]) {
            res = dp(str1, str2, i - 1, j - 1) + 1;
        } else {
            res = Math.max(dp(str1, str2, i - 1, j), dp(str1, str2, i, j - 1));
        }
        dpMap.put(i + "-" + j, res);
        return res;
    }
}
