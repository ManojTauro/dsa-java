import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

        //Map<PrefixSum, count>
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int rem = prefixSum - k;

            count += map.getOrDefault(rem, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println(count);
    }
}
