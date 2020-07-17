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

    public static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int asc = s.charAt(i);
            if (asc >= 97 && asc <= 122) {
                stringBuilder.append(ch);
            } else if (asc >= 65 && asc <= 90) {
                ch = (char) (asc + 32);
                stringBuilder.append(ch);
            } else if (asc >= 48 && asc <= 57) {
                stringBuilder.append(ch);
            }
        }
        String left = stringBuilder.toString();
        String right = stringBuilder.reverse().toString();
        return left.equals(right);
    }

    public static boolean isPalindrome3(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.isLetterOrDigit(s.charAt(left)) != Character.isLetterOrDigit(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome3("A man, a plan, a canal: Panama"));
    }
}
