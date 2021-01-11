package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/9 8:51 上午
 * @Version 1.0
 **/
public class CanJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }

}
