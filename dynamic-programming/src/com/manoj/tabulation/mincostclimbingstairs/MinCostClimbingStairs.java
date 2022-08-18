package com.manoj.tabulation.mincostclimbingstairs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinCostClimbingStairs {
    private final static int[] cost = {10,15,20};

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;

        List<Integer> list = Arrays.stream(cost)
                .boxed()
                .collect(Collectors.toList());
        list.add(0);

        System.out.println(list.toString());

        for(int i=list.size() - 3; i>=0; i--) {
            Integer min = Math.min(list.get(i+1), list.get(i+2));
            list.set(i, list.get(i) + min);
        }

        return Math.min(list.get(0),list.get(1));
    }
}
