package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/19 8:15
 */
public class TrailingZeroes {

    public static int trailingZeroes(int n) {
        long res = fn(n);
        String str = String.valueOf(res);
        int counter = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    public static long fn(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fn(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }
}
