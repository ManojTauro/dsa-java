import java.util.HashMap;
import java.util.Map;

public class CountPairWithGivenSum {
    private static final int[] input = {1, 5, 7, -1, 5, 1};
    private static final int target = 6;

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;

        for(int i=0; i<input.length; i++) {
            if(map.containsKey(target - input[i])) count += map.get(target - input[i]);

            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }

        System.out.println("Total number of pairs: "+count);
    }
}
