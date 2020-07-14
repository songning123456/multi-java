package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/14 12:35
 */
public class MySqrt {
    private static int mySqrt1(int x) {
        int max = 0;
        for (int i = 0; i <= x/2; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                if (max < i) {
                    max = i;
                }
            }
        }
        return max;
    }

    private static int mySqrt2(int x){
        int min = 0, max = x / 2 + 1, res = -1;
        while (min <= max) {
            int mid = min + (max - min + 1) /2;
            if (mid * mid <= x) {
                res = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(8));
    }
}
