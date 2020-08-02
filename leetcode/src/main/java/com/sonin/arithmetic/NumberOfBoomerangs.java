package com.sonin.arithmetic;

/**
 * @author sonin
 * @date 2020/8/2 7:56
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int counter = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    if (i != j && i != k && j != k) {
                        int a = (points[i][0] - points[k][0]) * (points[i][0] - points[k][0]) + (points[i][1] - points[k][1]) * (points[i][1] - points[k][1]);
                        int b = (points[j][0] - points[k][0]) * (points[j][0] - points[k][0]) + (points[j][1] - points[k][1]) * (points[j][1] - points[k][1]);
                        if (a == b) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }
}
