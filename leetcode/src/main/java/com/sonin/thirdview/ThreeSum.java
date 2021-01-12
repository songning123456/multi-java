package com.sonin.thirdview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sonin
 * @date 2021/1/12 17:04
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int target = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        Arrays.sort(nums);
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                res.add(new ArrayList<Integer>() {
                    {
                        add(left);
                        add(right);
                    }
                });
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum.threeSum(nums);
    }
}
