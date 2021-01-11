package com.sonin.secondview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author sonin
 * @Date 2021/1/9 8:15 上午
 * @Version 1.0
 **/
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    private int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        Arrays.sort(intvs, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int xEnd = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= xEnd) {
                count++;
                xEnd = interval[1];
            }
        }
        return count;
    }

}
