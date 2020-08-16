package com.sonin.simple;

import java.util.*;

/**
 * @author sonin
 * @date 2020/8/5 20:39
 */
public class SimpleLc {

    /**
     * 岛屿的周长
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        count--;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        count--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        count--;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        count--;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 供暖器
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int i, j;
        for (i = 0; i < houses.length; i++) {
            for (j = 0; j < heaters.length - 1; j++) {
                if (Math.abs(heaters[j] - houses[i]) < Math.abs(heaters[j + 1] - houses[i])) {
                    break;
                }
            }
            res = Math.max(Math.abs(heaters[j] - houses[i]), res);
        }
        return res;
    }

    /**
     * 数字的补数
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            stringBuilder.append(num % 2);
            num /= 2;
        }
        String str = stringBuilder.reverse().toString();
        int sum = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int k = str.charAt(i) - 48;
            if (k == 0) {
                int res = 1;
                int m = str.length() - 1;
                while (m > i) {
                    res *= 2;
                    m--;
                }
                sum = sum + res;
            }
        }
        return sum;
    }

    /**
     * 密钥格式化
     *
     * @param S
     * @param K
     * @return
     */
    public static String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (i == 0 || i % K != 0) {
                if (cur != '-') {
                    stringBuilder.append(cur).append("-");
                }
            } else {
                if (cur != '-') {
                    stringBuilder.append(cur);
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 最大连续1的个数
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int ans = 0;
        for (int num : nums) {
            if (num == 1) {
                ans++;
            } else if (num == 0) {
                max = Math.max(max, ans);
                ans = 0;
            }
        }
        return Math.max(max, ans);
    }

    /**
     * 构造矩形
     *
     * @param area
     * @return
     */
    public static int[] constructRectangle(int area) {
        int[] min = new int[]{1, 1};
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int l = 1; l <= area; l++) {
            int w = area / l;
            if (w * l == area && l >= w) {
                map.put(l, w);
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            int l = item.getKey();
            int w = item.getValue();
            if (min[0] == 1 && min[1] == 1) {
                min[0] = l;
                min[1] = w;
            } else if (min[0] - min[1] > l - w) {
                min[0] = l;
                min[1] = w;
            }
        }
        return min;
    }

    /**
     * 下一个更大元素
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (j + 1 < nums2.length) {
                        int k = j + 1;
                        for (; k < nums2.length; k++) {
                            if (nums2[k] > nums1[i]) {
                                break;
                            }
                        }
                        if (k < nums2.length) {
                            res.add(nums2[k]);
                        } else {
                            res.add(-1);
                        }
                    } else {
                        res.add(-1);
                    }
                }
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }

    /**
     * 键盘行
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        return new String[2];
    }

    /**
     * 相对名次
     *
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        Arrays.sort(nums);
        String[] res = new String[nums.length];
        int j = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (j == 0) {
                res[j++] = "Gold Medal";
            } else if (j == 1) {
                res[j++] = "Silver Medal";
            } else if (j == 2) {
                res[j++] = "Bronze Medal";
            } else {
                res[j++] = String.valueOf(j);
            }
        }
        return res;
    }

    /**
     * 完美树
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != sum) {
                    sum += num / i;
                }
            }
        }
        return sum == 2 * num;
    }

    /**
     * 斐波那契数列
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public boolean detectCapitalUse(String word) {
        boolean res = false;
        int flag = 0;
        int temp = word.charAt(0);
        if (temp >= 97 && temp <= 122) {
            flag = 1;
        } else if (temp >= 65 && temp <= 90) {
            flag = 2;
        }
        if (flag == 1) {
            int i = 1;
            while (i < word.length()) {
                temp = word.charAt(i);
                if (temp >= 65 && temp <= 90) {
                    break;
                }
                i++;
            }
            if (i == word.length()) {
                res = true;
            }
        } else if (flag == 2) {
            int i = 1;
            int count = 0;
            while (i < word.length()) {
                temp = word.charAt(i);
                if (temp >= 65 && temp <= 90) {
                    count++;
                }
                if (temp >= 97 && temp <= 122) {
                    count--;
                }
                i++;
            }
            if (Math.abs(count) == word.length() - 1) {
                res = true;
            }
        }
        return res;
    }

    /**
     * 最长特殊序列
     *
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        return 1;
    }

    /**
     * 反转字符串
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += 2 * k) {
            int left = i;
            int right = (i + k - 1 < len) ? (i + k - 1) : len - 1;
            while (left <= right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = strs[i].length() - 1; j >= 0; j--) {
                sb.append(strs[i].charAt(j));
            }
            if (i != strs.length - 1) {
                sb.append(" ");
            }
            stringBuilder.append(sb);
        }
        return stringBuilder.toString();
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    private boolean isOrder(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] sort = nums.clone();
        Arrays.sort(sort);
        int start = nums.length - 1, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sort[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start > 0) ? (end - start + 1) : 0;
    }

    public static void main(String[] args) {
        SimpleLc simpleLc = new SimpleLc();
        int[] nums = new int[]{1, 2, 3, 5, 4};
        simpleLc.findUnsortedSubarray(nums);
    }
}
