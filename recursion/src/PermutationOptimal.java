import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=13
// For basic approach please look at Leetcode
public class PermutationOptimal {
    private static final int[] input = {1,2,3};

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        permuteOptimal(0, input, result);

        System.out.println(result);
    }

    private static List<List<Integer>> permuteOptimal(int index, int[] input, List<List<Integer>> result) {
        if(index == input.length) {
            List<Integer> curPermutation = new ArrayList<>();
            for(int i=0; i<input.length; i++) curPermutation.add(input[i]);

            result.add(new ArrayList<>(curPermutation));
        }

        for(int i=index; i<input.length; i++) {
            swap(index, i, input);
            permuteOptimal(index + 1, input, result);
            swap(index, i, input);
        }
        return result;
    }

    private static void swap(int index, int curIndex, int[] input) {
        int temp = input[curIndex];
        input[curIndex] = input[index];
        input[index] = temp;
    }
}
