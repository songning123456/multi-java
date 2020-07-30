package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/30 22:21
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>(2);
        Map<Character, Integer> map2 = new HashMap<>(2);
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            int counter = map1.getOrDefault(character, 0) + 1;
            map1.put(character, counter);
        }
        for (int i = 0; i < t.length(); i++) {
            Character character = t.charAt(i);
            int counter = map2.getOrDefault(character, 0) + 1;
            map2.put(character, counter);
        }
        for (int i = 0; i < t.length(); i++) {
            Character character = t.charAt(i);
            int count1 = map1.getOrDefault(character, 0);
            int count2 = map2.getOrDefault(character, 0);
            if (count2 - count1 == 1) {
                return character;
            }
        }
        return 'a';
    }
}
