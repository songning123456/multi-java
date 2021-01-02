package com.sonin.secondview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author sonin
 * @Date 2021/1/2 7:27 下午
 * @Version 1.0
 **/
public class GenerateParenthesis {

    private final List<List<Character>> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        backtrack(n, n, new LinkedList<>());
        List<String> result = new ArrayList<>();
        for (List<Character> item : res) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character ch : item) {
                stringBuilder.append(ch);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    private void backtrack(int left, int right, LinkedList<Character> track) {
        if (right < left) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        track.add('(');
        backtrack(left - 1, right, track);
        track.removeLast();

        track.add(')');
        backtrack(left, right - 1, track);
        track.removeLast();
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(1);
        System.out.println();
    }
}
