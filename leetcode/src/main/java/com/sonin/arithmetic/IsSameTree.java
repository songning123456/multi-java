package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/15 13:55
 */
public class IsSameTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    public static void main(String[] args) {
//        System.out.println(isSameTree());
    }
}
