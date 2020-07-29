package com.sonin.arithmetic;

import java.util.*;

/**
 * @author sonin
 * @date 2020/7/28 22:53
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int value : nums1) {
            for (int i : nums2) {
                if (value == i) {
                    set.add(value);
                }
            }
        }
        Integer[] temp = set.toArray(new Integer[]{});
        int[] res = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            res[i] = temp[i];
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        int count = 0;
        int[] res = new int[nums1.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int num : nums1) {
            count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        for (int num : nums2) {
            count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
