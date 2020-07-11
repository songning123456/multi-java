package com.sonin.arithmetic;

import java.util.Scanner;

/**
 * @author sonin
 * @date 2020/7/11 16:20
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome {

    private static boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        boolean flag = true;
        for (int i = 0, j = str.length() - 1; j >= i; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPalindrome1(scanner.nextInt()));
    }
}
