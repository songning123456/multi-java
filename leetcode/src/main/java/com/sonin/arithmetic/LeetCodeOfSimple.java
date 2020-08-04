package com.sonin.arithmetic;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @Author sonin
 * @Date 2020/8/3 10:50 下午
 * @Version 1.0
 **/
public class LeetCodeOfSimple {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = 1;
        while (len <= s.length() / 2) {
            String temp = s.replaceAll(s.substring(0, len), "");
            if (temp == null || "".equals(temp)) {
                return true;
            }
            len++;
        }
        return false;
    }

    public int hammingDistance(int x, int y) {
        StringBuilder stringBufferX = new StringBuilder();
        StringBuilder stringBufferY = new StringBuilder();
        while (x != 0) {
            stringBufferX.append(x % 2);
            x /= 2;
        }
        while (y != 0) {
            stringBufferY.append(y % 2);
            y /= 2;
        }
        String strX = stringBufferX.toString();
        String strY = stringBufferY.toString();
        int min = Math.min(strX.length(), strY.length());
        int max = Math.max(strX.length(), strY.length());
        int count = 0;
        for (int i = 0; i < min; i++) {
            if (strX.charAt(i) != strY.charAt(i)) {
                count++;
            }
        }
        String compare;
        if (strX.length() > strY.length()) {
            compare = strX;
        } else if (strX.length() < strY.length()) {
            compare = strY;
        } else {
            compare = "";
        }
        for (int i = min; i < max; i++) {
            if (compare.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        repeatedSubstringPattern("abab");
    }
}
