package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/1 8:24 下午
 * @Version 1.0
 **/
public class MoveZeroes {

    private int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public void moveZeroes(int[] nums) {
        int index = this.removeElement(nums, 0);
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
