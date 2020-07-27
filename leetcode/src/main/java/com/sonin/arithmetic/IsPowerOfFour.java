package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/27 20:42
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num % 4 == 0) {
            return isPowerOfFour(num / 4);
        }
        return false;
    }
}
