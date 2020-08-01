package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/8/1 22:28
 */
public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= i) {
            n = n - i;
            i++;
        }
        return i - 1;
    }
}
