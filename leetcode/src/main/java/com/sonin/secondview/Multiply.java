package com.sonin.secondview;

/**
 * @Author sonin
 * @Date 2021/1/3 8:16 下午
 * @Version 1.0
 **/
public class Multiply {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < res.length) {
            stringBuilder.append(res[i]);
            i++;
        }
        String str = stringBuilder.toString();
        return str.length() == 0 ? "0" : str;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        multiply.multiply("2", "3");
        System.out.println();
    }
}
