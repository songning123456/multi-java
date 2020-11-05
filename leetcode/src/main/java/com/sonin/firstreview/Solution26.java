package com.sonin.firstreview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sonin
 * @date 2020/11/5 15:35
 */
public class Solution26 {

    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalSchedule(intervals);
    }

    private int intervalSchedule(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int xEnd = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= xEnd) {
                count++;
                xEnd = interval[1];
            }
        }
        return count;
    }
}
