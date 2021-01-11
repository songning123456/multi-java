package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/5 8:04 下午
 * @Version 1.0
 **/
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palindrome(String str, int l, int r) {
        int len = str.length();
        while ((l >= 0 && r < len) && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        String res = "";
        if (l >= -1 && r >= 1) {
            res = str.substring(l + 1, r - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String res = longestPalindrome.longestPalindrome("babad");
        System.out.println(res);
    }
}
