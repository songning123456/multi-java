package com.sonin.labuladong;

import com.sonin.arithmetic.components.ListNode;

import java.util.Random;

/**
 * @author sonin
 * @date 2020/10/31 15:34
 */
public class Solution3 {
    private ListNode head;

    public Solution3(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        Random r = new Random();
        int i = 0, res = 0;
        ListNode p = head;
        // while 循环遍历链表
        while (p != null) {
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (r.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
