package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/18 20:52
 */
public class TitleToNumber {

    public static int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int var = ch - 'A' + 1;
            int m = 1;
            for (int j = i; j < s.length() - 1; j++) {
                m *= 26;
            }
            res += var * m;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
