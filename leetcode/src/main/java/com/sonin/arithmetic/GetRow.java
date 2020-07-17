package com.sonin.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sonin
 * @date 2020/7/17 13:39
 */
public class GetRow {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> currentRow = new ArrayList<>();
        if (rowIndex == 0) {
            currentRow.add(1);
            return currentRow;
        } else if (rowIndex == 1) {
            currentRow.add(1);
            currentRow.add(1);
            return currentRow;
        }
        List<Integer> prevRow = getRow(rowIndex - 1);
        currentRow.add(1);
        for (int i = 1; i < rowIndex; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        currentRow.add(1);
        return currentRow;
    }

    public static void main(String[] args) {
        System.out.println(getRow(4));
    }
}
