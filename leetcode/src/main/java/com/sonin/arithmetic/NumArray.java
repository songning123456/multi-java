package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/27 20:50
 */
public class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += this.nums[k];
        }
        return sum;
    }
}
