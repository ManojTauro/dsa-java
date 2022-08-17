package com.manoj.tabulation.fib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    private static int fib(int n) {
        int[] table = new int[n+2];

        table[1] = 1;

        System.out.println(Arrays.toString(table));

            for(int i=0; i<n;  i++) {
                table[i+1] += table[i];
                table[i+2] += table[i];
            }

        System.out.println(Arrays.toString(table));

        return table[n];
    }
}
