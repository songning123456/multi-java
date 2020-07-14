package com.sonin.arithmetic;

import java.util.Scanner;

/**
 * @author sonin
 * @date 2020/7/14 16:39
 */
public class ClimbStairs {
    private static int climbStairs(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            count[i] = count[i - 2] + count[i - 1];
        }
        return count[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(climbStairs(scanner.nextInt()));
    }
}
