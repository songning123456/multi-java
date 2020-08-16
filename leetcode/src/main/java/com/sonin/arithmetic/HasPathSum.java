package com.sonin.arithmetic;

import com.sonin.entity.TreeNode;

/**
 * @author sonin
 * @date 2020/7/16 20:47
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
