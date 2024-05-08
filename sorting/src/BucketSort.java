import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(11, 9, 21, 8, 17, 19, 13, 1, 24, 12);

        sort(input, 5);
    }

    private static void sort(List<Integer> nums, int bucketSize) {
        int max = Collections.max(nums);
        int min = Collections.min(nums);
        int range = (max - min) / bucketSize;

        Map<Integer, List<Integer>> buckets = new HashMap<>();

        for (int e : nums) {
            int bucketIndex = (e - min) / range;
            if (!buckets.containsKey(bucketIndex))
                buckets.put(bucketIndex, new LinkedList<>());

            buckets.get(bucketIndex).add(e);
        }

        for (List<Integer> bucket : buckets.values()) Collections.sort(bucket);

        List<Integer> sortedList = new ArrayList<>();
        for (List<Integer> bucket : buckets.values()) {
            sortedList.addAll(bucket);
        }

        System.out.println("Sorted List -> " + sortedList.toString());
    }
}
