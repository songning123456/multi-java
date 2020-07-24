package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/24 22:05
 */
public class IsUgly {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] fac = new int[]{2, 3, 5};
        for (int item : fac) {
            while (num % item == 0) {
                num = num / item;
            }
        }
        return num == 1;
    }
}
