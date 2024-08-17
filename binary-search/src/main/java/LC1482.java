//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

import java.util.stream.IntStream;

public class LC1482 {

    public static void main(String[] args) {
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7,};
        int m = 2;
        int k = 3;
        int maxDay = IntStream.of(bloomDay).max().getAsInt();

        int low = 1;
        int high = maxDay;
        int minDays = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int bouquets = getBouquets(bloomDay, mid, k);
            if (bouquets >= m) {
                high = mid - 1;
                minDays = mid;
            } else low = mid + 1;
        }

        System.out.println(minDays);
    }

    private static int getBouquets(int[] bloomDay, int mid, int k) {
        int flowers = 0;
        int count = 0;
        for (int i : bloomDay) {
            if ((mid / i) >= 1) {
                flowers++;
            } else {
                flowers = 0;
            }

            if (flowers == k) {
                count++;
                flowers = 0;
            }
        }

        return count;
    }
}
