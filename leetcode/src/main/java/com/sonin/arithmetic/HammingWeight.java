package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/20 22:30
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            int temp = n & 1;
            if (temp == 1) {
                stringBuilder.append(n & 2);
            }
            n >>= 1;
        }
        return stringBuilder.length();
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(12));
    }
}
