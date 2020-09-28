package com.sonin.exe;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sonin
 * @date 2020/9/20 15:14
 */
public class SlideWindow {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

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


    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        if (!this.hasCycle(head)) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];
            if (b2 >= a1 && a2 >= b1) {
                int[] temp = new int[2];
                temp[0] = Math.max(a1, b1);
                temp[1] = Math.min(a2, b2);
                res.add(temp);
            }
            if (b2 < a2) {
                j += 1;
            } else {
                i += 1;
            }
        }
        return res.toArray(new int[0][]);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int[] cur, last;
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            cur = intervals[i];
            last = res.get(res.size() - 1);
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[0][]);
    }

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(0, nums, track);
        return list;
    }

    private void backtrack(int i, int[] nums, LinkedList<Integer> track) {
        list.add(new ArrayList<>(track));
        for (int j = i; j < nums.length; j++) {
            track.add(nums[j]);
            backtrack(j + 1, nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        SlideWindow slideWindow = new SlideWindow();
//        System.out.println(slideWindow.subsets(nums));
        System.out.println(slideWindow.multiply("123", "45"));
    }

    private List<List<Integer>> combineList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(0, n, k, new LinkedList<>());
        return combineList;
    }

    private void backtrack(int i, int n, int k, LinkedList<Integer> track) {
        if (track.size() == k) {
            combineList.add(new LinkedList<>(track));
            return;
        }
        for (int j = i; j < i + k && j < n; j++) {
            track.add(j);
            backtrack(j + 1, n, k, track);
            track.removeLast();
        }
    }

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < res.length) {
            stringBuilder.append(res[i]);
            i++;
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
