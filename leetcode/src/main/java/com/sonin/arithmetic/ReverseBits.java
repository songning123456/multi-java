package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/20 21:45
 */
public class ReverseBits {
    public static int reverseBits(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            stringBuilder.append(n % 2);
            n /= 2;
        }
        int len = 32 - stringBuilder.length();
        while (len > 0) {
            stringBuilder.append('0');
            len--;
        }
       return Integer.parseUnsignedInt(stringBuilder.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
