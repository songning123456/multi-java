package com.sonin.firstreview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sonin
 * @date 2020/11/5 9:47
 */
public class Solution19 {

    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? (o2[1] - o1[1]) : (o1[0] - o2[0]));
        int[] height = new int[length];
        for (int i = 0; i < length; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int poker : nums) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}
