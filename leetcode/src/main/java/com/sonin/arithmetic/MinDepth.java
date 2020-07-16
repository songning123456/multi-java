package com.sonin.arithmetic;

import com.sonin.arithmetic.components.TreeNode;

/**
 * @author sonin
 * @date 2020/7/16 20:08
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int m = minDepth(root.left);
        int n = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return m + n + 1;
        }
        return Math.min(m, n) + 1;
    }
}
