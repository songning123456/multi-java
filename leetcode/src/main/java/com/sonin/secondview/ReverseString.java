package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/1 1:57 下午
 * @Version 1.0
 **/
public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
