package com.sonin.secondview;

import java.util.Stack;

/**
 * @Author sonin
 * @Date 2021/1/4 8:24 下午
 * @Version 1.0
 **/
public class Calculate {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isDigit(ch)) {
                num = 10 * num + (ch - '0');
            }
            if (ch == '(') {
                num = calculate(s.substring(i));
            }
            if ((!isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int prev = stack.pop();
                        stack.push(prev * num);
                        break;
                    case '/':
                        prev = stack.pop();
                        stack.push(prev / num);
                        break;
                    default:
                        break;
                }
                sign = ch;
                num = 0;
            }
            if (ch == ')') {
                return num;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.calculate("1 + 1");
        System.out.println();
    }
}
