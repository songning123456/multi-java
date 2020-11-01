package com.sonin.firstreview;

import java.util.*;

/**
 * @author sonin
 * @date 2020/11/1 17:09
 */
public class Solution8 {

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadends);
        Set<String> visitedSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        visitedSet.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visitedSet.contains(up)) {
                        queue.offer(up);
                        visitedSet.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visitedSet.contains(down)) {
                        queue.offer(down);
                        visitedSet.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(solution8.openLock(deadends, target));
    }
}
