package com.manoj.memoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Look at below video for different implementation - combination sum
//https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=9
public class AllSum {
    private static List<Integer> nums = new ArrayList<>(Arrays.asList(3, 2, 11, 7, 5,1));
    public static void main(String[] args) {

        System.out.println(allSum(5, nums));
    }

    private static List<List<Integer>> allSum(int target, List<Integer> nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(target == 0) return list;
        if(target < 0) return null;

        List<List<Integer>> result = new ArrayList<>();

        for(int num: nums) {
            int rem = target - num;
            List<List<Integer>> remainderWays = allSum(rem, nums); // Returns a list of how to construct a given remainder

            if(remainderWays != null && remainderWays.isEmpty() && rem == 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                result.add(temp);
            }

            if(remainderWays != null) {
                for (List<Integer> remainderWay : remainderWays) {
                    List<Integer> updatedList = new ArrayList<>();
                    updatedList.add(num);

                    for (int i : remainderWay) {
                        updatedList.add(i);
                    }

                    result.add(updatedList);
                }
            }
        }

        return result;
    }
}
