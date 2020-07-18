package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/18 20:25
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int num : nums) {
            Integer temp = map.get(num);
            if (temp == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++temp);
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > nums.length / 2) {
                return item.getKey();
            }
        }
        return -1;
    }
}
