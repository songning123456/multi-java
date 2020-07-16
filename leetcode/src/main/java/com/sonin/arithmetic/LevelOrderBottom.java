package com.sonin.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sonin
 * @date 2020/7/16 9:24
 */
public class LevelOrderBottom {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(level, new ArrayList<>());
        }
        list.get(level).add(root.val);
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }
}
