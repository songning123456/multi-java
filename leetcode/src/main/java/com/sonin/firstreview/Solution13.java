package com.sonin.firstreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/4 15:05
 */
public class Solution13 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        Map<Character, Integer> needs = new HashMap<>(2);
        Map<Character, Integer> window = new HashMap<>(2);
        for (int i = 0; i < p.length(); i++) {
            Character character = p.charAt(i);
            needs.put(character, needs.getOrDefault(character, 0) + 1);
        }
        int match = 0;
        while (right < s.length()) {
            Character rCh = s.charAt(right);
            if (needs.containsKey(rCh)) {
                window.put(rCh, window.getOrDefault(rCh, 0) + 1);
                if (window.get(rCh).equals(needs.get(rCh))) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                Character lCh = s.charAt(left);
                if (needs.containsKey(lCh)) {
                    window.put(lCh, window.get(lCh) - 1);
                    if (window.get(lCh) < needs.get(lCh)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
