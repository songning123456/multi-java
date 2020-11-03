package com.sonin.firstreview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/1 20:00
 */
public class Solution11 {

    public String minWindow(String s, String t) {
        int[] startEnd = new int[]{0, Integer.MAX_VALUE};
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>(2);
        Map<Character, Integer> needs = new HashMap<>(2);
        for (int i = 0; i < t.length(); i++) {
            Character character = t.charAt(i);
            needs.put(character, needs.getOrDefault(character, 0) + 1);
        }
        int match = 0;
        while (right < s.length()) {
            Character ch = s.charAt(right);
            if (needs.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(needs.get(ch))) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (right - left < startEnd[1] - startEnd[0]) {
                    startEnd[0] = left;
                    startEnd[1] = right;
                }
                char ch2 = s.charAt(left);
                if (needs.containsKey(ch2)) {
                    window.put(ch2, window.get(ch2) - 1);
                    if (window.get(ch2) < needs.get(ch2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return startEnd[1] - startEnd[0] == Integer.MAX_VALUE ? "" : s.substring(startEnd[0], startEnd[1]);
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println();
    }
}
