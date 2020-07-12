package com.sonin.arithmetic;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sonin
 * @date 2020/7/12 9:47
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
public class IsValid {

    private static boolean equals(Character s1, Character s2) {
        if (s1 == '(' && s2 == ')') {
            return true;
        } else if (s1 == '[' && s2 == ']') {
            return true;
        } else if (s1 == '{' && s2 == '}') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValid1(String s) {
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                list.add(s.charAt(i));
            } else {
                if (list.isEmpty()) {
                    return false;
                }
                Character character = list.get(list.size() - 1);
                if (equals(character, s.charAt(i))) {
                    list.remove(list.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return list.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isValid1(scanner.next()));
    }
}
