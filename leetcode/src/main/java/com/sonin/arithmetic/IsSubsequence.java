package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/8/1 8:43
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return false;
        }
        int sIndex = 0, tIndex = 0;
        while (sIndex != s.length() && tIndex != t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}
