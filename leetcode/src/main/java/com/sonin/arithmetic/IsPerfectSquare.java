package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/29 21:13
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int val = num / 2;
        int left = 2, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = mid * mid;
            if (guess == val) {
                return true;
            } else if (guess > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
