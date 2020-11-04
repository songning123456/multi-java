package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/4 17:16
 */
public class Solution16 {

    private int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, S);
        return result;
    }

    private void backtrack(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) {
                result++;
            }
            return;
        }
        rest += nums[i];
        backtrack(nums, i + 1, rest);
        rest -= nums[i];

        rest -= nums[i];
        backtrack(nums, i + 1, rest);
        rest += nums[i];
    }
}
