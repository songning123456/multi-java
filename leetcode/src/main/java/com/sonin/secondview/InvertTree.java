package com.sonin.secondview;

import com.sonin.entity.TreeNode;

/**
 * @Author sonin
 * @Date 2021/1/6 8:33 下午
 * @Version 1.0
 **/
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
