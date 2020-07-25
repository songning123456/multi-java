package com.sonin.arithmetic;

import java.util.List;

/**
 * @author sonin
 * @date 2020/7/25 19:40
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int[] copy = new int[nums.length];
        int i = 0, j = nums.length - 1;
        for (int num : nums) {
            if (num == 0) {
                copy[j--] = 0;
            } else {
                copy[i++] = num;
            }
        }
        System.arraycopy(copy, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
}
