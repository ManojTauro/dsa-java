package com.manoj.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeightedUniformString {
    public static void main(String[] args) {
        String input = "abccddde";
        List<Integer> q = Arrays.asList(6, 1, 3, 12, 5, 9, 10);

        System.out.println(weightedUniformStrings(input, q));
    }

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        List<Integer> weights = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int curWeight = cur - 'a' + 1;
            weights.add(curWeight);

            int weight = curWeight;
            while (i < s.length() - 1 && s.charAt(i + 1) == cur) {
                weight += curWeight;
                weights.add(weight);
                i++;
            }
        }

        System.out.println(weights);

        List<String> ans = new ArrayList<>();
        for (int i : queries) {
            if (weights.contains(i)) ans.add("YES");
            else ans.add("NO");
        }

        return ans;
    }
}
