package com.sonin.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sonin
 * @date 2020/8/2 19:43
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int len = nums[i] - nums[i - 1];
            int counter = 0;
            while (len > 1) {
                counter++;
                res.add(nums[i - 1] + counter);
                len--;
            }
        }
        return res;
    }
}
