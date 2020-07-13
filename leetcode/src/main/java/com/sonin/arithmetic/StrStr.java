package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/12 21:58
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class StrStr {

    private static int strStr(String haystack, String needle) {
        if (haystack == null || "".equals(haystack)) {
            if (needle == null || needle.length() > 0) {
                return -1;
            } else {
                return 0;
            }
        } else {
            if (needle == null) {
                return -1;
            }
            if (haystack.contains(needle)) {
                return haystack.indexOf(needle);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
