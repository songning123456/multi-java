package com.sonin.secondview;

/**
 * @author sonin
 * @date 2021/1/13 14:17
 */
public class CorpFlightBookings {

    static class Difference {

        private int[] diff;

        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            difference.increment(i, j, val);
        }
        return difference.result();
    }

    public static void main(String[] args) {
        CorpFlightBookings corpFlightBookings = new CorpFlightBookings();
        int[][] bookings = new int[][]{
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        int[] res = corpFlightBookings.corpFlightBookings(bookings, 5);
        System.out.println(res);
    }
}
