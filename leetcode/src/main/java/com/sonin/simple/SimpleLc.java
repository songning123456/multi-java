package com.sonin.simple;

import java.util.Arrays;

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
}
