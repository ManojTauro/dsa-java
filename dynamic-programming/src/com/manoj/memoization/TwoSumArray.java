package com.manoj.memoization;

import java.util.Arrays;

class TwoSumArray {
    public static void main(String[] args) {
        int[] nums = {3, 3, 2,11, 7, 5};
        System.out.println(Arrays.toString(twoSum(nums, 13)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null) return null;

        return getTwoSum(target, numbers);
    }

    private static int[] getTwoSum(int target, int[] numbers) {
        int length = numbers.length;

        if(target == 0) return new int[length];
        if(target < 0) return null;

        for(int i=0; i<length; i++) {
            int rem = target - numbers[i];
            int[] result = getTwoSum(rem, numbers);

            if(result != null) {
                int[] returnArray = new int[result.length];

                System.arraycopy(result, 0, returnArray, 0, returnArray.length);

                returnArray[returnArray.length - i - 1] = numbers[i];
                return returnArray;
            }
        }

        return null;
    }
}
