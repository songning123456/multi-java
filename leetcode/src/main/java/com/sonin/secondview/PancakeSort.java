package com.sonin.secondview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sonin
 * @Date 2021/1/3 5:38 下午
 * @Version 1.0
 **/
public class PancakeSort {

    private final List<Integer> res = new ArrayList<>();

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
}
