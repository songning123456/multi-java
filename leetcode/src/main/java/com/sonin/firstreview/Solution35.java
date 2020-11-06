package com.sonin.firstreview;

/**
 * @author sonin
 * @date 2020/11/6 13:32
 */
public class Solution35 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }
}
