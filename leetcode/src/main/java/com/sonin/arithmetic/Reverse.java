package com.sonin.arithmetic;

import java.util.Scanner;

/**
 * @author sonin
 * @date 2020/7/11 13:03
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Reverse {

    private static int reverse1(int x) {
        int result = 0, temp = x;
        if (temp > 0) {
            while (temp / 10 > 0 || temp % 10 > 0) {
                int m = temp % 10;
                result = result * 10 + m;
                temp = temp / 10;
            }
        } else if (temp < 0) {
            temp = Math.abs(temp);
            while (temp / 10 > 0 || temp % 10 > 0) {
                int m = temp % 10;
                result = result * 10 + m;
                temp = temp / 10;
            }
            result = result * -1;
        }
        return result;
    }

    private static int reverse2(int x) {
        long result;
        if (x >= 0) {
            String str = String.valueOf(x);
            StringBuilder stringBuilder = new StringBuilder(str);
            result = Long.parseLong(stringBuilder.reverse().toString());
        } else {
            String str = String.valueOf(x);
            StringBuilder stringBuilder = new StringBuilder(str.replace("-", ""));
            result = Long.parseLong("-" + stringBuilder.reverse().toString());
        }
        return (int) result == result ? (int) result : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(reverse1(scanner.nextInt()));
    }
}
