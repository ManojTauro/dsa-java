//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

public class ArraySortedAndRotated {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(isSortedAndRotated(array));
    }

    private static boolean isSortedAndRotated(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > nums[(i+1) % nums.length]) {
                count++;
            }
        }

        return count <= 1;
    }
}
