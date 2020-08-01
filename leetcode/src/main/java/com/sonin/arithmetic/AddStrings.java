package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/8/1 16:24
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(num1.length(), num2.length());
        StringBuilder stringBuilder = new StringBuilder();
        if (num1.length() < len) {
            for (int i = 0; i < len - num1.length(); i++) {
                stringBuilder.append(0);
            }
            num1 = stringBuilder.toString() + num1;
        } else if (num2.length() < len) {
            for (int i = 0; i < len - num2.length(); i++) {
                stringBuilder.append(0);
            }
            num2 = stringBuilder.toString() + num2;
        }
        int flag = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int int1 = Integer.parseInt(num1.charAt(i) + "");
            int int2 = Integer.parseInt(num2.charAt(i) + "");
            int temp = int1 + int2 + flag;
            if (temp >= 10) {
                sb.append(temp - 10);
                flag = 1;
            } else {
                sb.append(temp);
                flag = 0;
            }
        }
        if (flag == 1) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        addStrings("9133", "0");
    }
}
