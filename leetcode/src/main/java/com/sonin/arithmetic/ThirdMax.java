package com.sonin.arithmetic;

import java.util.*;

/**
 * @author sonin
 * @date 2020/8/1 16:08
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        Set<Integer> sortSet = new TreeSet<>(Comparator.reverseOrder());
        for (int num : nums) {
            sortSet.add(num);
        }
        List<Integer> list = new ArrayList<>(sortSet);
        if (list.size() >= 3) {
            return list.get(2);
        } else {
            return list.get(0);
        }
    }
}
