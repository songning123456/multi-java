package com.sonin.firstreview;

import java.util.Arrays;

/**
 * @author sonin
 * @date 2020/11/4 15:53
 */
public class Solution15 {

    public int coinChange(int[] coins, int amount) {
        int[] dpTable = new int[amount + 1];
        Arrays.fill(dpTable, amount + 1);
        dpTable[0] = 0;
        for (int i = 0; i < dpTable.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dpTable[i] = Math.min(dpTable[i], 1 + dpTable[i - coin]);
            }
        }
        if (dpTable[amount] == amount + 1) {
            return -1;
        } else {
            return dpTable[amount];
        }
    }
}
