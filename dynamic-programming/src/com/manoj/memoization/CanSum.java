package com.manoj.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    private static int[] nums = new int[]{5, 3, 4, 100};
    private static int[] nums1 = new int[]{2, 3};
    private static int[] nums2 = new int[]{7, 14};

    public static void main(String[] args) {
        Map<Integer, Boolean> memo = new HashMap<>();

        System.out.println(canSum(1, nums, memo));
        System.out.println(canSum(7, nums1, memo));
        System.out.println(canSum(300, nums2, memo));
    }

    private static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        if (memo.containsKey(targetSum)) return memo.get(targetSum);

        for (int num : numbers) {
            int rem = targetSum - num;

            if (canSum(rem, numbers, memo)) {
                memo.put(rem, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }
}
