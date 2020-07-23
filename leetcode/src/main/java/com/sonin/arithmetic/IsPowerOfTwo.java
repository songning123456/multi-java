package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/23 21:57
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 2) {
            return true;
        }
        int start = 2;
        while (start < n) {
            start *= 2;
        }
        return start == n;
    }
}
