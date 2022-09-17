import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {
    private static String input = "abc";
    private static int[] nums = {1,2,3};

    public static void main(String[] args) {
        List<List<String>> permutationList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        List<List<Integer>> permutationListInt = new ArrayList<>();
        List<Integer> tempListInt = new ArrayList<>();
        boolean[] pick = new boolean[input.length()];
        Arrays.fill(pick, false);

//        recurPermutation(input, permutationList, tempList, pick);
        recurPermutationInteger(nums, permutationListInt, tempListInt, pick);

        System.out.println(permutationListInt);
    }

    private static void recurPermutation(String str, List<List<String>> result, List<String> temp, boolean[] pick) {
        if(temp.size() == str.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        char[] s = str.toCharArray();

        for(int i=0; i<s.length; i++) {
            if(!pick[i]) {
                temp.add(String.valueOf(s[i]));
                pick[i] = true;
                recurPermutation(str, result, temp, pick);
                pick[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static void recurPermutationInteger(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] pick) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!pick[i]) {
                temp.add(nums[i]);
                pick[i] = true;
                recurPermutationInteger(nums, result, temp, pick);
                pick[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
