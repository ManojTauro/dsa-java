import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 3}};

        int n = intervals.length;

        Comparator<int[]> arrayComparator = (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        };

        Arrays.sort(intervals, arrayComparator);

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<List<Integer>> result1 = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (end >= intervals[i][0]) {
                if (end <= intervals[i][1])
                    end = intervals[i][1];
            } else {
                result1.add(Arrays.asList(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result1.add(Arrays.asList(start, end));

        int[][] resultArray = result1.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        System.out.println(Arrays.deepToString(resultArray));
    }
}
