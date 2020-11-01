package com.sonin.labuladong;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sonin
 * @date 2020/11/1 9:31
 */
public class Solution5 {

    private List<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    private void sort(int[] cakes, int n) {
        if (n == 1) {
            return;
        }
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        reverse(cakes, 0, n - 1);
        res.add(n);
        sort(cakes, n - 1);
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.hammingWeight(00000000000000000000000000001011));
    }
}
