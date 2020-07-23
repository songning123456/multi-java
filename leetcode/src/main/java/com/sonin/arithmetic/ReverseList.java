package com.sonin.arithmetic;

import com.sonin.arithmetic.components.ListNode;

/**
 * @author sonin
 * @date 2020/7/23 19:47
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
