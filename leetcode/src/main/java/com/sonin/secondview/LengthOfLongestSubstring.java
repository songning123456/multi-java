package com.sonin.secondview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author sonin
 * @Date 2021/1/2 2:21 下午
 * @Version 1.0
 **/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>(2);
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            Character toEnter = s.charAt(right);
            right++;
            window.put(toEnter, window.getOrDefault(toEnter, 0) + 1);
            while (window.get(toEnter) > 1) {
                Character toLeave = s.charAt(left);
                left++;
                window.put(toLeave, window.get(toLeave) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
