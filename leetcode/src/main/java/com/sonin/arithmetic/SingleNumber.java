package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/18 9:06
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            Integer temp = map.get(nums[i]);
            if (temp == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], ++temp);
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) {
                return item.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
