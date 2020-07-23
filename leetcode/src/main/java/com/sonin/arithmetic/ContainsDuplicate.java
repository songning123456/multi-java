package com.sonin.arithmetic;

import java.util.*;

/**
 * @author sonin
 * @date 2020/7/23 20:20
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tList = map.get(nums[i]);
            if (tList == null) {
                tList = new ArrayList<>();
            }
            tList.add(i);
            map.put(nums[i], tList);
        }
        for (Map.Entry<Integer, List<Integer>> item : map.entrySet()) {
            List<Integer> tmpList = item.getValue();
            if (tmpList.size() > 1) {
                for (int i = 0; i < tmpList.size() - 1; i++) {
                    if (tmpList.get(i + 1) - tmpList.get(i) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
