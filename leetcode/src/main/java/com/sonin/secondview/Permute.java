package com.sonin.secondview;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author sonin
 * @Date 2021/1/2 5:57 下午
 * @Version 1.0
 **/
public class Permute {

    private final List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
