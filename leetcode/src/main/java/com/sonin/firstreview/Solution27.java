package com.sonin.firstreview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sonin
 * @date 2020/11/5 16:00
 */
public class Solution27 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int xEnd = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > xEnd) {
                count++;
                xEnd = point[1];
            }
        }
        return count;
    }
}
