package com.sonin.arithmetic;

import com.sonin.arithmetic.components.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sonin
 * @date 2020/7/18 12:44
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!= null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
