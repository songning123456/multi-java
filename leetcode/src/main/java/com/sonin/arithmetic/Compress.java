package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/8/1 23:33
 */
public class Compress {
    public int compress(char[] chars) {
        int left = 0, right = 0, size = 0;
        while (right <= chars.length) {
            if (right == chars.length || chars[left] != chars[right]) {
                chars[size++] = chars[left];
                if (right - left > 1) {
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
            right++;
        }
        return size;
    }
}
