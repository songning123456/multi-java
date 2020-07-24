package com.sonin.arithmetic;

import com.sonin.arithmetic.components.ListNode;

/**
 * @author sonin
 * @date 2020/7/24 19:18
 */
public class DeleteNode {

    public void deleteNode(ListNode head, int target) {
        ListNode sen = new ListNode(-1);
        sen.next = head;
        ListNode pre = sen;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == target) {
                pre.next = cur.next;
            }
            pre = pre.next;
            cur = cur.next;
        }
    }
}
