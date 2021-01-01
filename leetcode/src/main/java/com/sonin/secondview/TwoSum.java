package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/1 11:25 上午
 * @Version 1.0
 **/
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
