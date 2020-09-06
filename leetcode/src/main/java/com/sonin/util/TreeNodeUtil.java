package com.sonin.util;

import com.sonin.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sonin
 * @date 2020/9/3 22:33
 */

/**
 * add      增加一个元索                  如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove   移除并返回队列头部的元素       如果队列为空，则抛出一个NoSuchElementException异常
 * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
 * offer    添加一个元素并返回true         如果队列已满，则返回false
 * poll     移除并返问队列头部的元素        如果队列为空，则返回null
 * peek     返回队列头部的元素              如果队列为空，则返回null
 * put      添加一个元素                   如果队列满，则阻塞
 * take     移除并返回队列头部的元素
 * @author sonin
 */
public class TreeNodeUtil {
    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    assert node != null;
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    assert node != null;
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }
}
