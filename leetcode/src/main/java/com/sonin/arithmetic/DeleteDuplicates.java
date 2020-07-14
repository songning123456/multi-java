package com.sonin.arithmetic;

import java.util.List;

/**
 * @author sonin
 * @date 2020/7/14 20:28
 */
public class DeleteDuplicates {
    static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(deleteDuplicates(listNode1));
    }
}
