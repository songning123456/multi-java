package com.sonin.arithmetic;

import java.util.Scanner;

/**
 * @author sonin
 * @date 2020/7/13 9:19
 */
public class CountAndSay {
    private static String countAndSay1(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char prev = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char cur = str.charAt(j);
                if (prev == str.charAt(j)) {
                    count++;
                } else {
                    stringBuilder.append(count).append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            stringBuilder.append(count).append(prev);
            str = stringBuilder.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countAndSay1(scanner.nextInt()));
    }
}
