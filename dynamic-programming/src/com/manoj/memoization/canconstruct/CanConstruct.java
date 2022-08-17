package com.manoj.memoization.canconstruct;

import java.util.*;

/*
 * CoderByte youtube channel
 * Return if it's possible to create the target string based from the WB
 * canConstruct("abcdef", [ab, abc, cd, def, abcd]) -> output should be TRUE
 */
public class CanConstruct {

    private static Map<String, Boolean> memo = new HashMap<>();
    private static List<String> input1 = new ArrayList<>(Arrays.asList(new String[]{"ab", "abc", "cd", "def", "abcd"}));
    private static List<String> input2 = new ArrayList<>(Arrays.asList(new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    private static List<String> input3 = new ArrayList<>(Arrays.asList(new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee"}));

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", input1, memo));
        System.out.println(canConstruct("skateboard", input2, memo));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", input3, memo));
    }

    private static boolean canConstruct(String t, List<String> wb, Map<String, Boolean> memo) {
        if(memo.containsKey(t)) return memo.get(t);
        if(t.isEmpty()) return true;

        for(String w: wb) {
            if(t.indexOf(w) == 0) {
                String suffix = t.substring(w.length());
                if(canConstruct(suffix, wb, memo)) {
                    memo.put(t, true);
                    return true;
                }
            }
        }

        memo.put(t, false);
        return false;
    }
}
