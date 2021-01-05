package com.sonin.secondview;

import java.util.Stack;

/**
 * @Author sonin
 * @Date 2021/1/5 9:01 下午
 * @Version 1.0
 **/
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && leftOf(ch) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char leftOf(char ch) {
        if (ch == ')') {
            return '(';
        } else if (ch == ']') {
            return '[';
        } else {
            return '{';
        }
    }

}
