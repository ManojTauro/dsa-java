package com.manoj;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Initialize memoization table with -1
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);

        // Call the recursive helper function
        int result = coinChangeHelper(coins, amount, memo);

        // Check if a valid combination was found
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int coinChangeHelper(int[] coins, int remainingAmount, int[] memo) {
        // Base case: If remainingAmount is 0, no more coins are needed
        if (remainingAmount == 0) {
            return 0;
        }

        // Check if the result is already memoized
        if (memo[remainingAmount] != -1) {
            return memo[remainingAmount];
        }

        // Initialize result to a large value
        int result = Integer.MAX_VALUE;

        // Try each coin denomination
        for (int coin : coins) {
            // Skip if the coin value is greater than the remaining amount
            if (coin <= remainingAmount) {
                // Recursively calculate the result for the remaining amount after using the current coin
                int subResult = coinChangeHelper(coins, remainingAmount - coin, memo);

                // If a valid combination is found, update the result
                if (subResult != -1) {
                    result = Math.min(result, subResult + 1);
                }
            }
        }

        // Memoize the result before returning
        memo[remainingAmount] = (result == Integer.MAX_VALUE) ? -1 : result;
        return (result == Integer.MAX_VALUE) ? -1 : result;
//        return memo[remainingAmount];
    }

    private static int coinChangeTabulation(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        Arrays.fill(table, (int) Math.pow(10, 9));

        table[0] = 0;

        for (int a = 1; a < amount + 1; a++) {
            for (int c : coins) {
                int rem = a - c;
                if (rem >= 0) {
                    table[a] = Math.min(table[a], 1 + table[rem]);
                }
            }
        }

        return table[amount] == (int) Math.pow(10, 9) ? -1 : table[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChangeSolver = new CoinChange();
//        int[] coins = {186, 419, 83, 408};
        int[] coins = {2};
        int amount = 6249;
//        int result = coinChangeSolver.coinChange(coins, amount);
        int result = coinChangeTabulation(coins, 3);
        System.out.println("Minimum number of coins required: " + result);
    }
}
