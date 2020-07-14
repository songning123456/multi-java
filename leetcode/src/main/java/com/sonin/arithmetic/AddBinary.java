package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/7/14 9:46
 */
public class AddBinary {

    private static String addBinary1(String a, String b) {
        String x,y;
        if (a.length() >= b.length()) {
            x = a;
            int len = a.length() - b.length();
            StringBuilder stringBuilder = new StringBuilder();
            while (len != 0) {
                stringBuilder.append("0");
                len--;
            }
            y = stringBuilder.append(b).toString();
        } else {
            x = b;
            int len = b.length() - a.length();
            StringBuilder stringBuilder = new StringBuilder();
            while (len != 0) {
                stringBuilder.append("0");
                len--;
            }
            y = stringBuilder.append(a).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int flag = 0;
        for (int i = x.length() - 1; i >=0; i--) {
            if ((int)x.charAt(i) - (int)('0') + (int)y.charAt(i) - (int)('0') + flag == 0) {
                flag = 0;
                stringBuilder.append(0);
            } else if ((int)x.charAt(i) - (int)('0') + (int)y.charAt(i) - (int)('0') + flag == 1) {
                flag = 0;
                stringBuilder.append(1);
            } else if ((int)x.charAt(i) - (int)('0') + (int)y.charAt(i) - (int)('0') + flag == 2) {
                flag = 1;
                stringBuilder.append(0);
            } else if ((int)x.charAt(i) - (int)('0') + (int)y.charAt(i) - (int)('0') + flag == 3) {
                flag = 1;
                stringBuilder.append(1);
            }
        }
        if (flag == 1) {
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary1(a, b));
    }
}
