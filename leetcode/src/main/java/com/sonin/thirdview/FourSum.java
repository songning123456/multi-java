package com.sonin.thirdview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sonin
 * @date 2021/1/12 17:33
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || len < n) {
            return res;
        }
        if (n == 2) {
            int lo = start, hi = len - 1;
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
        } else {
            for (int i = start; i < len; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
