package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/27 20:17
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 3) {
            return false;
        }
        int step = 3, res = 1;
        while (res < n) {
            res *= step;
        }
        return res == n;
    }
}
