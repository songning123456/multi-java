package com.sonin.secondview;

import com.sonin.entity.ListNode;

/**
 * @Author sonin
 * @Date 2021/1/1 11:19 上午
 * @Version 1.0
 **/
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        fast = slow = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            assert head != null;
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
