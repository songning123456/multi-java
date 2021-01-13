package com.sonin.secondview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sonin
 * @date 2021/1/13 13:23
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> count = new HashMap<>(2);
        Map<Character, Boolean> inStack = new HashMap<>(2);
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        for (char ch : charArray) {
            count.put(ch, count.get(ch) - 1);
            if (inStack.getOrDefault(ch, false)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch) {
                if (count.get(stack.peek()) == 0) {
                    break;
                }
                inStack.put(stack.pop(), false);
            }
            stack.push(ch);
            inStack.put(ch, true);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        removeDuplicateLetters.removeDuplicateLetters("bcabc");
        System.out.println();
    }

}
