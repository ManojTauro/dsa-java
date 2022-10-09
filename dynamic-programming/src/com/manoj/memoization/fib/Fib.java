package com.manoj.memoization.fib;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    private static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibRecursive(10));
//       printFib(5, 1, 1);
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

    //len - max length of the series
    //curElement - current element in the series
    //curLength - Current length of the series
    private static void printFib(int len, int curElement, int curLength) {
        if(curElement > len) return;
        if(curElement <=2) {
            System.out.print(1+" ");
//            return;
        }

        System.out.print(curElement+" ");

        printFib(len,  curElement + 1, curLength+1);
        printFib(len,  curElement + 2, curLength+1);
    }
}
