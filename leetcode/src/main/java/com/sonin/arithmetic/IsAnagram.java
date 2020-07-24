package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/24 19:39
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>(2);
        Map<Character, Integer> tMap = new HashMap<>(2);
        for (int i = 0; i < s.length(); i++) {
            Character sC = s.charAt(i);
            Character tC = t.charAt(i);
            Integer sI = sMap.get(sC);
            Integer tI = tMap.get(tC);
            if (sI == null) {
                sMap.put(sC, 1);
            } else {
                sMap.put(sC, sI + 1);
            }
            if (tI == null) {
                tMap.put(tC, 1);
            } else {
                tMap.put(tC, tI + 1);
            }
        }
        for (Map.Entry<Character, Integer> item : sMap.entrySet()) {
            Character key = item.getKey();
            Integer value = item.getValue();
            Integer tValue = tMap.get(key);
            if (!value.equals(tValue)) {
                return false;
            }
        }
        return true;
    }
}
