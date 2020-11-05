package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/5 16:08
 */
public class Solution28 {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}
