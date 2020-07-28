package com.sonin.arithmetic;

import java.util.HashSet;
import java.util.Set;

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

//    public int[] intersect(int[] nums1, int[] nums2) {
//
//    }
}
