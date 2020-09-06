package com.sonin.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sonin
 * @date 2020/9/2 22:05
 */
public class NQueens {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> border = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(".");
            }
            border.add(stringBuilder.toString());
        }
        backtrack(border, 0);
        return result;
    }

    private void backtrack(List<String> border, int row) {
        if (row == border.size()) {
            List<String> temp = new ArrayList<>(border);
            result.add(temp);
            return;
        }
        int n = border.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(border, row, col)) {
                continue;
            }
            this.replace(border, row, col, 'Q');
            backtrack(border, row + 1);
            this.replace(border, row, col, '.');
        }

    }

    private boolean isValid(List<String> border, int row, int col) {
        int n = border.size();
        for (int i = 0; i < n; i++) {
            if (border.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (border.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (border.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void replace(List<String> params, int row, int col, Character newVal) {
        String oldStr = params.get(row);
        StringBuilder sb = new StringBuilder(oldStr);
        sb.setCharAt(col, newVal);
        params.set(row, sb.toString());
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }
}
