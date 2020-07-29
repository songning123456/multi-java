package com.sonin.arithmetic;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/29 21:58
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> ranMap = new HashMap<>(2);
        for (int i = 0; i < ransomNote.length(); i++) {
            Character character = ransomNote.charAt(i);
            int count = ranMap.getOrDefault(character, 0) + 1;
            ranMap.put(character, count);
        }
        Map<Character, Integer> maMap = new HashMap<>(2);
        for (int i = 0; i < magazine.length(); i++) {
            Character character = magazine.charAt(i);
            int count = maMap.getOrDefault(character, 0) + 1;
            maMap.put(character, count);
        }
        for (Map.Entry<Character, Integer> item : ranMap.entrySet()) {
            Character key = item.getKey();
            Integer value = item.getValue();
            if (maMap.get(key) == null || value > maMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
