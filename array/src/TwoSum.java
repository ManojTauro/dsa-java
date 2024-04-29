import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int remTarget = target - nums[i];

            if (map.containsKey(remTarget)) {
                ans[0] = map.get(remTarget);
                ans[1] = i;
            } else map.put(nums[i], i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(input, 6)));
    }
}