package com.manoj.memoization.fib;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    public static void main(String[] args) {
        Map<Integer, Long> memo = new HashMap<>();

        System.out.println(fib(7, memo));
        System.out.println(fib(8, memo));
        System.out.println(fib(9, memo));
        System.out.println(fib(50, memo));
    }

    private static long fib(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;

        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }
}