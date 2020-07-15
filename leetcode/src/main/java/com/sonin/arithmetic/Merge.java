package com.sonin.arithmetic;


import java.util.Arrays;

/**
 * @author sonin
 * @date 2020/7/15 9:07
 */
public class Merge {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static void merge1(int[] nums1, int m, int[] nums2, int n) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < m; i++) {
            cur.next = new ListNode(nums1[i]);
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < n; i++) {
            while (cur.next != null) {
                if (nums2[i] == cur.val) {
                    ListNode t = new ListNode(nums2[i]);
                    ListNode l = cur.next;
                    cur.next = t;
                    t.next = l;
                    break;
                } else if (nums2[i] > cur.val && nums2[i] < cur.next.val) {
                    ListNode temp = new ListNode(nums2[i]);
                    ListNode l = cur.next;
                    cur.next = temp;
                    temp.next = l;
                    break;
                }
                cur = cur.next;
            }
            if (cur.next == null && nums2[i] > cur.val) {
                cur.next = new ListNode(nums2[i]);
            }
            cur = head;
        }
        int index = 0;
        while (head.next != null) {
            nums1[index] = head.next.val;
            index++;
            head = head.next;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};
        int m = 1;
        int n = 1;
        merge1(nums1, m, nums2, n);
    }
}
