package com.manoj.fib;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    private static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        callDP();
    }

    private static void callDP() {
        System.out.println(fibDP(6, memo));
        System.out.println(fibDP(7, memo));
        System.out.println(fibDP(8, memo));
        System.out.println(fibDP(50, memo));
    }

    private static long fibRecursive(int n) {
        if(n<=2) return 1;

        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    private static long fibDP(long n, Map<Long, Long> memo) {
        if(memo.containsKey(n)) return memo.get(n);

        if(n<=2) return 1;

        long result = fibDP(n-1, memo) + fibDP(n-1, memo);

        memo.put(n, result);

        return result;
    }
}
