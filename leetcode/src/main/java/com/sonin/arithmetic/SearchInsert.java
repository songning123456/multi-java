package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/13 8:49
 */
public class SearchInsert {

    private static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }
}
