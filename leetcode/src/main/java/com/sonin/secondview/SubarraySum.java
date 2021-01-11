package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/2 10:07 下午
 * @Version 1.0
 **/
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
