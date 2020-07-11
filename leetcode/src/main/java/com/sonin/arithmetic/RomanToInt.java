package com.sonin.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sonin
 * @date 2020/7/11 21:45
 */
public class RomanToInt {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    private static int romanToInt1(String s) {
        int result = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (i < len - 1) {
                if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                    result += map.get(s.charAt(i));
                } else {
                    result += (map.get(s.charAt(i + 1)) - map.get(s.charAt(i)));
                    i++;
                }
            } else if (i == len - 1) {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(romanToInt1(scanner.next()));
    }
}
