package com.manoj.memoization.LIS;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        int len = nums.length;

        int[][] memo = new int[len + 1][len];
        for (int[] row : memo) Arrays.fill(row, -1);

        System.out.println(lengthOfLISMemo(nums, 0, -1, memo));
    }

    private static int lengthOfLISMemo(int[] nums, int ind, int prev_ind, int[][] memo) {
        if (ind == nums.length) return 0;
//        if (memo[ind][prev_ind + 1] != -1) return memo[ind][prev_ind + 1];

        int not_take = lengthOfLISMemo(nums, ind + 1, prev_ind, memo);

        int take = 0;
        if (prev_ind == -1 || nums[ind] > nums[prev_ind])
            take = 1 + lengthOfLISMemo(nums, ind + 1, ind, memo);

//        return memo[ind][prev_ind + 1] = Math.max(take, not_take);
        return Math.max(take, not_take);
    }
}
