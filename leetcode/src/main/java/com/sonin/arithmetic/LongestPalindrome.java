package com.sonin.arithmetic;

import java.util.*;

/**
 * @author sonin
 * @date 2020/8/1 15:39
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>(2);
        int jiCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            int value = map.getOrDefault(character, 0);
            if (value % 2 == 0) {
                count += value;
            } else if (value % 2 == 1) {
                jiCount = 1;
                count += (value - 1);
            }
            map.remove(character);
        }
        return count + jiCount;
    }
}
