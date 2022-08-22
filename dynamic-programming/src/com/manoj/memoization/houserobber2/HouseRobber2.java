package com.manoj.memoization.houserobber2;

import java.util.Arrays;

public class HouseRobber2 {

    public static void main(String[] args) {

        final int[] nums = {2,3,2};
        if (nums.length == 1) System.out.println(nums[0]);

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int includeFirst = helper(nums, 0, nums.length-2, memo);

        Arrays.fill(memo, -1);

        int excludeFirst = helper(nums, 1, nums.length - 1, memo);

        System.out.println(Math.max(includeFirst, excludeFirst));
    }

    private static int helper(int[] nums, int start, int end, int[] memo) {
        int[] copy = new int[end-start+1];

        for(int i=start, j=0; i<=end; i++, j++) {
            copy[j] = nums[i];
        }

        return robRecursive(copy, 0, memo);
    }

    private static int robRecursive(int[] nums, int i, int[] memo) {
        if(i >= nums.length) return 0;

        if(memo[i] >= 0) return memo[i];

        int pick = nums[i] + robRecursive(nums, i + 2, memo);
        int notPick = robRecursive(nums, i + 1,memo);

        memo[i] = Math.max(pick, notPick);

        return memo[i];
    }
}
