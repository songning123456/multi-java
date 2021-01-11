package com.sonin.secondview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author sonin
 * @Date 2021/1/2 11:06 上午
 * @Version 1.0
 **/
public class MinWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(2);
        Map<Character, Integer> window = new HashMap<>(2);
        for (Character ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int valid = 0, left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            Character toEnter = s.charAt(right);
            right++;
            if (need.containsKey(toEnter)) {
                window.put(toEnter, window.getOrDefault(toEnter, 0) + 1);
                if (window.get(toEnter).equals(need.get(toEnter))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                Character toLeave = s.charAt(left);
                left++;
                if (need.containsKey(toLeave)) {
                    if (window.get(toLeave).equals(need.get(toLeave))) {
                        valid--;
                    }
                    window.put(toLeave, window.get(toLeave) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
