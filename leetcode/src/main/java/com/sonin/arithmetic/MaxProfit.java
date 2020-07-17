package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/17 13:58
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int val = prices[j] - prices[i];
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(nums));
    }
}
