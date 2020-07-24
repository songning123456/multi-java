package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/24 20:18
 */
public class AddDigits {

    public int addDigits(int num) {
        String str = String.valueOf(num);
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum < 10) {
            return sum;
        } else {
            return addDigits(sum);
        }
    }
}
