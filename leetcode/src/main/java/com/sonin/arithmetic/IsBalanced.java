package com.sonin.arithmetic;

import com.sonin.entity.TreeNode;

/**
 * @author sonin
 * @date 2020/7/16 15:20
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dfs(root.left) - dfs(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
