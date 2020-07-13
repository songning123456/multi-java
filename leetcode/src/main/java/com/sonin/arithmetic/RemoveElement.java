package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/12 18:15
 */
public class RemoveElement {
    private static int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement1(nums, 3));
    }
}
