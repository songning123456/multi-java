package com.sonin.secondview;

import com.sonin.entity.ListNode;

/**
 * @Author sonin
 * @Date 2021/1/1 6:55 下午
 * @Version 1.0
 **/
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
