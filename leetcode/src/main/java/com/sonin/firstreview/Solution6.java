package com.sonin.firstreview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sonin
 * @date 2020/11/1 14:46
 */
public class Solution6 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.permute(new int[]{1, 2, 3}));
    }
}
