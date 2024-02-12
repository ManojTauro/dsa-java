package com.manoj;

import java.util.Arrays;

public class CountSubSetsWithSumK {
    public static void main(String[] args) {
        int[] num = {0, 1, 3};
        int target = 4;

//        System.out.println(findWays(num, target));
        System.out.println(numberOfWaysTab(num, target));
    }


    public static int findWays(int[] num, int target) {

        int n = num.length;

        int[][] memo = new int[n][target + 1];

        for (int[] row : memo) Arrays.fill(row, -1);

        return numberOfWays(n - 1, target, n, num, memo);
    }

    private static int numberOfWays(int ind, int target, int n, int[] num, int[][] memo) {
        if (ind < 0) {
            if (target == 0) return 1;
            else return 0;
        }

        System.out.println("ind - " + ind + " target - " + target);

        if (memo[ind][target] != -1) return memo[ind][target];

        int notPick = numberOfWays(ind - 1, target, n, num, memo);

        int pick = 0;
        if (num[ind] <= target)
            pick = numberOfWays(ind - 1, target - num[ind], n, num, memo);

        return memo[ind][target] = pick + notPick % (int) (1e9 + 7);
    }

    private static int numberOfWaysTab(int[] num, int target) {
        int[][] dp = new int[num.length + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= num.length; i++) dp[i][0] = 1;

        for (int i = 1; i <= num.length; i++) {
            for (int k = 0; k <= target; k++) {
                int notPick = dp[i - 1][k];

                int pick = 0;
                if (num[i - 1] <= k)
                    pick = dp[i - 1][k - num[i - 1]];

                dp[i][k] = (pick + notPick) % (int) (1e9 + 7);

                for (int[] row : dp)
                    System.out.println(Arrays.toString(row));

                System.out.println();
            }
        }

        for (int[] row : dp)
            System.out.println(Arrays.toString(row));

        return dp[num.length][target];
    }
}
