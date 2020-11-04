package com.sonin.firstreview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/4 15:19
 */
public class Solution14 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>(2);
        int res = 0;
        while (right < s.length()) {
            Character rCh = s.charAt(right);
            window.put(rCh, window.getOrDefault(rCh, 0) + 1);
            right++;
            while (window.get(rCh) > 1) {
                Character lCh = s.charAt(left);
                window.put(lCh, window.get(lCh) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
