package com.sonin.firstreview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/11/1 13:16
 */
public class Solution1 {
    public int fib(int N) {
        if (N < 1) {
            return 0;
        }
        Map<Integer, Integer> memory = new HashMap<>(2);
        return helper(memory, N);
    }

    private Integer helper(Map<Integer, Integer> memory, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memory.get(n) != null) {
            return memory.get(n);
        }
        memory.put(n, helper(memory, n - 1) + helper(memory, n - 2));
        return memory.get(n);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.fib(10));
    }
}
