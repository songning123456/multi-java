package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/21 22:47
 */
public class IsHappy {

    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (slow != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(fast);
        }
        return slow == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int s = n % 10;
            sum = s * s + sum;
            n /= 10;
        }
        return sum;
    }
}
