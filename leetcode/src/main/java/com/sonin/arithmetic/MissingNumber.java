package com.sonin.arithmetic;

import java.util.Arrays;

/**
 * @author sonin
 * @date 2020/7/25 18:48
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i - 1] + 1;
            }
        }
        return -1;
    }
}
