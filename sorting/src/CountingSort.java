import java.util.Arrays;
import java.util.Collections;

public class CountingSort {
    public static void main(String[] args) {
        Integer[] array = {4, 3, 12, 1, 5, 5, 3, 9};

        System.out.println(Arrays.toString(sortArray(array)));
    }

    private static int[] sortArray(Integer[] nums) {
        int[] result;
        result = new int[nums.length];

        int max = Collections.max(Arrays.asList(nums));

        int[] countArray = new int[max + 1];

        //count frequencies of each element
        for (Integer num : nums) countArray[num]++;

        // Prefix sum
        for (int i = 1; i <= max; i++)
            countArray[i] = countArray[i - 1] + countArray[i];

        for (int i = nums.length - 1; i >= 0; i--) {
            result[countArray[nums[i]] - 1] = nums[i];
            countArray[nums[i]]--;
        }
        return result;
    }
}