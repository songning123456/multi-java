package com.sonin.secondview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author sonin
 * @Date 2021/1/1 9:27 下午
 * @Version 1.0
 **/
public class TwoSumII {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (indexMap.containsKey(other) && indexMap.get(other) != i) {
                return new int[]{i, indexMap.get(other)};
            }
        }
        return new int[]{-1, -1};
    }
}
