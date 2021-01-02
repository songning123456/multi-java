package com.sonin.secondview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author sonin
 * @Date 2021/1/2 6:19 下午
 * @Version 1.0
 **/
public class Subsets {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(0, nums, track);
        return res;
    }

    private void backtrack(int i, int[] nums, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int j = i; j < nums.length; j++) {
            track.add(nums[j]);
            backtrack(j + 1, nums, track);
            track.removeLast();
        }
    }
}
