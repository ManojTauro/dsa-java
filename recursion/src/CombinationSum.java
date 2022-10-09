import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] input = {2,3,6,7};
        int target = 7;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curCombination = new ArrayList<>();

        findCombination(0, target, input, curCombination, result);

        for(List<Integer> l: result) {
            System.out.println(l);
        }
    }

    private static void findCombination(int i, int target, int[] candidates, List<Integer> curCombination, List<List<Integer>> result) {
        if(i == candidates.length) {
            if(target == 0)
                result.add(new ArrayList<>(curCombination));
            return;
        }

        // if(i >= candidates.length) return;

        // Pick the current element
        if(candidates[i] <= target) {
            curCombination.add(candidates[i]);
            // target -= candidates[i];
            findCombination(i, target - candidates[i], candidates, curCombination, result);
            // remove this because the next call will be when we are not picking
            // the current element.
            // target += candidates[i];
            curCombination.remove(curCombination.size() - 1);

        }

        // Don't pick the current element
        findCombination(i+1, target, candidates, curCombination, result);
    }
}
