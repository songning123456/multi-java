package com.sonin.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sonin
 * @date 2020/7/17 9:29
 */
public class Generate {

    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = null;
        if (numRows == 1) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
            result.get(0).add(1);
            return result;
        }
        result = generate(numRows - 1);
        List<Integer> lastRow = result.get(numRows - 2);
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            newRow.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        newRow.add(1);
        result.add(newRow);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
