package com.manoj.memoization.twosum;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        List<Integer> list =  twoSum(nums, 9, 0);
//        list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(list);
    }

    private static List<Integer> twoSum(int[] nums, int target, int curIndex) {
        if(target == 0) return new ArrayList<>();
        if(curIndex >= nums.length || target < 0) return null;
        // if(target == 0) return new int[nums.length];


        for(int i = curIndex; i<nums.length; i++) {
            int rem = target - nums[i];
            List<Integer> result = twoSum(nums, rem, curIndex + 1);

            if(result != null) {
                List<Integer> returnList = new ArrayList<>(result);
                // System.arraycopy(result, 0, returnList, 0, returnList.length);
                // returnList[returnList.length - i - 1] = i;
                returnList.add(i);

                return returnList;
            }
        }

        return null;
    }
}
