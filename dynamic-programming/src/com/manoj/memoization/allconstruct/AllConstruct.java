package com.manoj.memoization.allconstruct;

import java.util.*;

/*
 * CoderByte youtube channel
 * Return all the ways we can create the target string based from the WB
 * canConstruct("abcdef", [ab, abc, cd, def, abcd]) -> output should be [[abc, def]]
 */
public class AllConstruct {
    private static Map<String, Integer> memo = new HashMap<>();
    private static List<String> input1 = new ArrayList<>(Arrays.asList(new String[]{"ab", "abc", "cd", "def", "abcd"}));
    private static List<String> input2 = new ArrayList<>(Arrays.asList(new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    private static List<String> input3 = new ArrayList<>(Arrays.asList(new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee"}));
    private static List<String> input4 = new ArrayList<>(Arrays.asList(new String[]{"purp", "p", "ur", "le", "purpl"}));
    private static List<String> input5 = new ArrayList<>(Arrays.asList(new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));


    public static void main(String[] args) {
        System.out.println(allConstruct("abcdef", input1));
        System.out.println(allConstruct("skateboard", input2));
        System.out.println(allConstruct("purple", input4));
//        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", input3));
        System.out.println(allConstruct("abcdef", input5));
    }

    private static List<List<String>> allConstruct(String t, List<String> wb) {
        List<List<String>> list = new ArrayList();
        if(t.isEmpty()) {
            return list;
        }

        List<List<String>> result = new ArrayList<>();

        for(String s: wb) {
            if(t.indexOf(s) == 0) {
                String suffix = t.substring(s.length());
                List<List<String>> suffixWays = allConstruct(suffix, wb);

                if(suffixWays.isEmpty() && suffix.isEmpty()) {
                    List<String> list1 = new ArrayList<>();
                    list1.add(s);
                    result.add(list1);
                }
                for(List<String> l: suffixWays) {
                    List<String> updateList = new ArrayList<>();
                    updateList.add(s);

                    for(String str: l) {
                        updateList.add(str);
                    }
                    result.add(updateList);
                }
            }
        }

        return result;
    }
}
