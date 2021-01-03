package com.sonin.secondview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author sonin
 * @Date 2021/1/3 12:48 下午
 * @Version 1.0
 **/
public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character == '+' || character == '*' || character == '-') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (character == '+') {
                            res.add(a + b);
                        } else if (character == '-') {
                            res.add(a - b);
                        } else if (character == '*') {
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
