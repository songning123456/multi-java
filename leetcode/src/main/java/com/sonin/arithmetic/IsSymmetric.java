package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/15 15:53
 */
public class IsSymmetric {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }

    public static void main(String[] args) {

    }
}
