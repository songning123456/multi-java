package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/12 8:14
 */
public class LongestCommonPrefix {

    private static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int len = Math.min(prefix.length(), strs[i].length());
            int index = 0;
            while (index < len && prefix.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            prefix = prefix.substring(0, index);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs1 = new String[]{"c", "c"};
        String[] strs2 = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix1(strs1));
        System.out.println(longestCommonPrefix1(strs2));
    }
}
