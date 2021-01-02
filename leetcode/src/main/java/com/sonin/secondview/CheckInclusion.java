package com.sonin.secondview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author sonin
 * @Date 2021/1/2 1:00 下午
 * @Version 1.0
 **/
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(2);
        Map<Character, Integer> window = new HashMap<>(2);
        for (Character ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            Character toEnter = s2.charAt(right);
            right++;

            if (need.containsKey(toEnter)) {
                window.put(toEnter, window.getOrDefault(toEnter, 0) + 1);
                if (window.get(toEnter).equals(need.get(toEnter))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                Character toLeave = s2.charAt(left);
                left++;
                if (need.containsKey(toLeave)) {
                    if (window.get(toLeave).equals(need.get(toLeave))) {
                        valid--;
                    }
                    window.put(toLeave, window.get(toLeave) - 1);
                }
            }
        }
        return false;
    }
}
