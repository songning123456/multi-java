package com.sonin.firstreview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/4 17:30
 */
public class Solution17 {

    Map<String, Integer> dpMap = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        return dp(nums, 0, S);
    }

    private int dp(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) {
                return 1;
            }
            return 0;
        }
        String key = i + "," + rest;
        if (dpMap.containsKey(key)) {
            return dpMap.get(key);
        }
        int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        dpMap.put(key, result);
        return result;
    }
}
