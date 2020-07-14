package com.sonin.arithmetic;

import java.util.Scanner;

/**
 * @author sonin
 * @date 2020/7/13 18:25
 */
public class LengthOfLastWord {

    private static int lengthOfLastWord1(String s) {
        String[] strs = s.split(" ");
        if (strs.length > 0) {
            return strs[strs.length - 1].length();
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(lengthOfLastWord1(" "));
    }
}
