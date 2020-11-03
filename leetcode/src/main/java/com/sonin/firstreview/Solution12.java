package com.sonin.firstreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/3 20:32
 */
public class Solution12 {

    public boolean checkInclusion(String s1, String s2) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        Map<Character, Integer> needs = new HashMap<>(2);
        Map<Character, Integer> window = new HashMap<>(2);
        for (int i = 0; i < s1.length(); i++) {
            Character character = s1.charAt(i);
            needs.put(character, needs.getOrDefault(character, 0) + 1);
        }
        int match = 0;
        while (right < s2.length()) {
            Character c1 = s2.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (right - left == s1.length()) {
                    res.add(left);
                }
                char c2 = s2.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res.size() != 0;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.checkInclusion("ab", "eidbaooo"));
        System.out.println();
    }
}
