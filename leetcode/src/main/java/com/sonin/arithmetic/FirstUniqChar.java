package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/30 21:55
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>(2);
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            int temp = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(character, temp);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
