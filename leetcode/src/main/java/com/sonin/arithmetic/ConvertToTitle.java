package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/18 18:25
 */
public class ConvertToTitle {
    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            int temp = n % 26;
            if (temp == 0) {
                temp = 26;
                n -= 1;
            }
            char ch = (char) ((char) ('0' + temp) + 16);
            stringBuilder.append(ch);
            n = n / 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
}
