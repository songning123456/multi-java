package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/5 10:52
 */
public class Solution22 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int cur = nums[0];
        int next = 0, res = cur;
        for (int i = 1; i < length; i++) {
            next = Math.max(nums[i], nums[i] + cur);
            cur = next;
            res = Math.max(res, next);
        }
        return res;
    }
}
