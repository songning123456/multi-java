package com.sonin.secondview;

import com.sonin.entity.TreeNode;

/**
 * @Author sonin
 * @Date 2021/1/6 8:37 下午
 * @Version 1.0
 **/
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
