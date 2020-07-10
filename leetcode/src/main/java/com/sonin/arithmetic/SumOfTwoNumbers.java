package com.sonin.arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/10 21:24
 * <p>
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 */
public class SumOfTwoNumbers {

    /**
     * 时间复杂度O(n²)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[j] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            if (map.containsKey(complete) && map.get(complete) != i) {
                return new int[]{i, map.get(complete)};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
//        System.out.println(Arrays.toString(twoSum1(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }
}
