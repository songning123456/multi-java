package com.sonin.arithmetic;

import com.sonin.arithmetic.components.ListNode;

/**
 * @author sonin
 * @date 2020/7/18 16:50
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode PA = headA, PB = headB;
        while (PA != PB) {
            PA = PA == null ? headB : PA.next;
            PB = PB == null ? headA : PB.next;
        }
        return PA;
    }
}
