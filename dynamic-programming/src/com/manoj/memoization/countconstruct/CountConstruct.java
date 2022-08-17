package com.manoj.memoization.countconstruct;

import java.util.*;

/*
 * CoderByte youtube channel
 * Return in how many ways we can create the target string based from the WB
 * canConstruct("abcdef", [ab, abc, cd, def, abcd]) -> output should be 1
 */
public class CountConstruct {
    private static Map<String, Integer> memo = new HashMap<>();
    private static List<String> input1 = new ArrayList<>(Arrays.asList(new String[]{"ab", "abc", "cd", "def", "abcd"}));
    private static List<String> input2 = new ArrayList<>(Arrays.asList(new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    private static List<String> input3 = new ArrayList<>(Arrays.asList(new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee"}));
    private static List<String> input4 = new ArrayList<>(Arrays.asList(new String[]{"purp", "p", "ur", "le", "purpl"}));

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", input1, memo));
        System.out.println(countConstruct("skateboard", input2, memo));
        System.out.println(countConstruct("purple", input4, memo));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", input3, memo));

    }

    private static int countConstruct(String t, List<String> wb, Map<String, Integer> memo) {
        if(memo.containsKey(t)) return memo.get(t);

        if(t.isEmpty()) return 1;

        int count = 0;

        for(String s: wb) {
            if(t.indexOf(s) == 0) {
                int numWays = countConstruct(t.substring(s.length()), wb, memo);
                memo.put(t, numWays);
                count += numWays;
            }
        }

        return count;
    }
}
