package com.sonin.arithmetic;


import java.util.*;

/**
 * @author sonin
 * @date 2020/7/13 22:29
 */
public class PlusOne {
    private static int[] plusOne1(int[] digits) {
        long sum = 0;
        List<Long> list = new ArrayList<>();
        int[] res;
        for (int digit : digits) {
            sum = sum * 10 + digit;
        }
        sum++;
        while (sum != 0) {
            list.add(sum % 10);
            sum /= 10;
        }
        if (list.size() != digits.length) {
            res = new int[digits.length + 1];
        } else {
            res = new int[digits.length];
        }
        for (int i = 0; i < list.size(); i++) {
            res[i] = Math.toIntExact(list.get(list.size() - i - 1));
        }
        return res;
    }

    private static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{8};
        System.out.println(Arrays.toString(plusOne2(digits)));
    }
}
