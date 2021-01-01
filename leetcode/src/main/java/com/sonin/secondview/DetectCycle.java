package com.sonin.secondview;

import com.sonin.entity.ListNode;

/**
 * @Author sonin
 * @Date 2021/1/1 10:56 上午
 * @Version 1.0
 **/
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
