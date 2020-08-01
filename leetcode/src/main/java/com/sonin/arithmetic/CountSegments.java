package com.sonin.arithmetic;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sonin
 * @date 2020/8/1 17:19
 */
public class CountSegments {
    public static int countSegments(String s) {
        String[] strings = s.split(" ");
        int res = 0;
        for (String str : strings) {
            if (!" ".equals(str) && !"".equals(str)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        countSegments("");
    }
}
