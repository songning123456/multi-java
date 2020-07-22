package com.sonin.arithmetic;

import com.sonin.arithmetic.components.ListNode;

/**
 * @author sonin
 * @date 2020/7/22 21:02
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pre = sentinel, cur = sentinel.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return sentinel.next;
    }
}
