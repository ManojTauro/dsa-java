package com.manoj.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * CoderByte youtube channel
 * Return the best combination of elements which results in target sum
 * canSum(7, [2, 3, 4, 7]) -> output should be TRUE
 */
public class CanSum {
    private static int[] nums = new int[]{5,3,4,100};
    private static int[] nums1 = new int[]{2,3};
    private static int[] nums2 = new int[]{7,14};

    public static void main(String[] args) {
        System.out.println(canSum(1, nums));
        System.out.println(canSum(7, nums1));
        System.out.println(canSum(300, nums2));
    }

    private static boolean canSum(int targetSum, int[] nums) {
        boolean[] table = new boolean[targetSum+1];

        for(int i=0; i<=targetSum; i++) table[i] = false;

        table[0] = true;


        for(int i=0; i<=targetSum; i++) {
            if(table[i] == true) {
                for(int j=0; j<nums.length; j++) {
                    if(i+nums[j] <= targetSum)
                        table[i+nums[j]] = true;
                }
            }
        }

        return table[targetSum];
    }
}
