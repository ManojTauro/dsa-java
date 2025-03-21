import java.util.ArrayList;
import java.util.List;

public class LC3488 {
    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>(queries.length);
        for (int i = 0; i < queries.length; i++) ans.add(-1);

        for (int i = 0; i < queries.length; i++) {
            int v = nums[queries[i]];

            int d = 0;
            for (int j = queries[i] + 1; j < 2 * nums.length - 1; j++) {
                if ((j % nums.length) == queries[i]) break;
                if (nums[j % nums.length] == v) {
                    int dis = 0;
                    if (j > nums.length) dis = Math.abs(queries[i] - (j % nums.length) - 1);
                    else dis = Math.abs(queries[i] - (j % nums.length));
                    if (ans.get(i) == -1 || dis < ans.get(i)) ans.set(i, dis);
                    // break;
                }
                d++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] in = {1, 3, 1, 4, 1, 3, 2};
        int[] q = {0, 3, 5};

        System.out.println(solveQueries(in, q));
    }
}
