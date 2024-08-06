public class MaximumSubArrayProduct {
    public static void main(String[] args) {
        int[] nums = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};

        System.out.println(kadanes(nums));
    }

    private static int kadanes(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(
                    curr,
                    Math.max(max_so_far * curr, min_so_far * curr)
            );
            min_so_far = Math.min(
                    curr,
                    Math.min(max_so_far * curr, min_so_far * curr)
            );

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }
}
