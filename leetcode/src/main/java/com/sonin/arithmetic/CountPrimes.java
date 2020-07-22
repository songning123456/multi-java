package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/22 21:37
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 1;
        }
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                for (int j = 2; i * j < n; j++) {
                    nums[i * j] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                res++;
            }
        }
        return res;
    }
}
