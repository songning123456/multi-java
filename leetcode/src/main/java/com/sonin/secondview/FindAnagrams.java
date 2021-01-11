package com.sonin.secondview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author sonin
 * @Date 2021/1/2 1:52 下午
 * @Version 1.0
 **/
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(2);
        Map<Character, Integer> window = new HashMap<>(2);
        for (Character ch : p.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            Character toEnter = s.charAt(right);
            right++;
            if (need.containsKey(toEnter)) {
                window.put(toEnter, window.getOrDefault(toEnter, 0) + 1);
                if (need.get(toEnter).equals(window.get(toEnter))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
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
        return res;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        findAnagrams.findAnagrams("cbaebabacd", "abc");
        System.out.println();
    }
}
