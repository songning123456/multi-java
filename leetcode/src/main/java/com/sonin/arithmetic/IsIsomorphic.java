package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/7/23 19:27
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        return isHelper(s, t) && isHelper(t, s);
    }

    public boolean isHelper(String str1, String str2) {
        int len = str1.length();
        Map<Character, Character> map = new HashMap<>(2);
        for (int i = 0; i < len; i++) {
            Character temp = map.get(str1.charAt(i));
            if (temp == null) {
                map.put(str1.charAt(i), str2.charAt(i));
            } else {
                if (temp != str2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
