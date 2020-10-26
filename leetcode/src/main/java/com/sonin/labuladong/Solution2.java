package com.sonin.labuladong;

import com.sonin.arithmetic.components.ListNode;

import java.util.*;

/**
 * @author sonin
 * @date 2020/10/24 10:30
 */
public class Solution2 {

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


    private int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = this.getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 寻找左侧边界的二分查找
    public int shipWithinDays(int[] weights, int D) {
        // 载重可能的最小值
        int left = getMax(weights);
        // 载重可能的最大值 + 1
        int right = getSum(weights) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinishCap(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int item : weights) {
            sum += item;
        }
        return sum;
    }

    // 如果载重为 cap，是否能在 D 天内运完货物？
    private boolean canFinishCap(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length) {
                    return true;
                }
            }
        }
        return false;
    }

    private int leftBound(ArrayList<Integer> arr, int tar) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (tar > arr.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        Map<Character, List<Integer>> indexMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            Character character = t.charAt(i);
            indexMap.computeIfAbsent(character, k -> new ArrayList<>());
            indexMap.get(character).add(i);
        }
        int j = 0;
        for (int i = 0; i < m; i++) {
            Character character = s.charAt(i);
            if (indexMap.get(character) == null) {
                return false;
            }
            int pos = leftBound((ArrayList<Integer>) indexMap.get(character), j);
            if (pos == indexMap.get(character).size() || pos == -1) {
                return false;
            }
            j = indexMap.get(character).get(pos) + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        boolean res = solution2.isSubsequence("abc", "ahbgdc");
//        System.out.println(res);
//        int[][] intervals = {{1, 2}};
//        solution2.eraseOverlapIntervals(intervals);
        solution2.isValid("{}");
        System.out.println();
    }

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }

    private int base = 1337;

    private int myPow(int a, int k) {
        a %= base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= base;
        }
        return res;
    }

    public int superPow(int a, int[] b) {
        if (b.length == 0) {
            return 1;
        }
        int last = b[b.length - 1];
        b = Arrays.copyOfRange(b, 0, b.length - 1);

        int part1 = myPow(a, last);
        int part2 = myPow(superPow(a, b), 10);
        return (part1 * part2) % base;
    }

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int ans = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    private int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        // 按 end 升序排序
        Arrays.sort(intvs, Comparator.comparingInt(a -> a[1]));
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int xEnd = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= xEnd) {
                // 找到下一个选择的区间了
                count++;
                xEnd = interval[1];
            }
        }
        return count;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalSchedule(intervals);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }

    private ListNode reverse(ListNode a) {
        ListNode prev, cur, next;
        prev = null;
        cur = a;
        while (cur != null) {
            next = cur.next;
            // 逐个结点反转
            cur.next = prev;
            // 更新指针位置
            prev = cur;
            cur = next;
        }
        // 返回反转后的头结点
        return prev;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode prev, cur, next;
        prev = null;
        cur = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 返回反转后的头结点
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }
        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }

    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(' || character == '{' || character == '[') {
                left.push(character);
            } else {
                if (!left.empty() && leftOf(character) == left.peek()) {
                    left.pop();
                } else {
                    return false;
                }
            }
        }
        return left.empty();
    }

    private char leftOf(Character c) {
        if (c == '}') {
            return '{';
        } else if (c == '}') {
            return '}';
        } else {
            return ']';
        }
    }
}
