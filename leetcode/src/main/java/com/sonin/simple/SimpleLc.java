package com.sonin.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sonin
 * @date 2020/8/5 20:39
 */
public class SimpleLc {

    /**
     * 岛屿的周长
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        count--;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        count--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        count--;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        count--;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 供暖器
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int i, j;
        for (i = 0; i < houses.length; i++) {
            for (j = 0; j < heaters.length - 1; j++) {
                if (Math.abs(heaters[j] - houses[i]) < Math.abs(heaters[j + 1] - houses[i])) {
                    break;
                }
            }
            res = Math.max(Math.abs(heaters[j] - houses[i]), res);
        }
        return res;
    }

    /**
     * 数字的补数
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            stringBuilder.append(num % 2);
            num /= 2;
        }
        String str = stringBuilder.reverse().toString();
        int sum = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int k = str.charAt(i) - 48;
            if (k == 0) {
                int res = 1;
                int m = str.length() - 1;
                while (m > i) {
                    res *= 2;
                    m--;
                }
                sum = sum + res;
            }
        }
        return sum;
    }

    /**
     * 密钥格式化
     *
     * @param S
     * @param K
     * @return
     */
    public static String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (i == 0 || i % K != 0) {
                if (cur != '-') {
                    stringBuilder.append(cur).append("-");
                }
            } else {
                if (cur != '-') {
                    stringBuilder.append(cur);
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 最大连续1的个数
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int ans = 0;
        for (int num : nums) {
            if (num == 1) {
                ans++;
            } else if (num == 0) {
                max = Math.max(max, ans);
                ans = 0;
            }
        }
        return Math.max(max, ans);
    }

    /**
     * 构造矩形
     *
     * @param area
     * @return
     */
    public static int[] constructRectangle(int area) {
        int[] min = new int[]{1, 1};
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int l = 1; l <= area; l++) {
            int w = area / l;
            if (w * l == area && l >= w) {
                map.put(l, w);
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            int l = item.getKey();
            int w = item.getValue();
            if (min[0] == 1 && min[1] == 1) {
                min[0] = l;
                min[1] = w;
            } else if (min[0] - min[1] > l - w) {
                min[0] = l;
                min[1] = w;
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        findComplement(2);
//        licenseKeyFormatting("2-5g-3-J", 2);
        constructRectangle(2);
    }
}
