import java.util.Arrays;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        int curSeqLength = 1;

        if (nums.length == 0 || nums.length == 1) return nums.length;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] != nums[i - 1] + 1) {
                maxLength = Math.max(maxLength, curSeqLength);
                curSeqLength = 1;
            } else curSeqLength++;
        }

        maxLength = Math.max(maxLength, curSeqLength);

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums1 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

//        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive(nums1));
    }
}
