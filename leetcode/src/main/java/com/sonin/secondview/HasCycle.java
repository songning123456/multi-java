package com.sonin.secondview;

import com.sonin.entity.ListNode;

/**
 * @Author sonin
 * @Date 2021/1/1 10:47 上午
 * @Version 1.0
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
