package com.sonin.secondview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author sonin
 * @Date 2021/1/2 6:39 下午
 * @Version 1.0
 **/
public class Combine {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new LinkedList<>());
        return res;
    }

    private void backtrack(int i, int n, int k, LinkedList<Integer> track) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
        }
        for (int j = i; j <= n; j++) {
            track.add(j);
            backtrack(j + 1, n, k, track);
            track.removeLast();
        }
    }
}
