package com.sonin.secondview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author sonin
 * @Date 2021/1/9 8:34 上午
 * @Version 1.0
 **/
public class FindMinArrowShots {

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
