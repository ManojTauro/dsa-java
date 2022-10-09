import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This problem can be modified to return all the subsequences, one sub sequence, and count the number of sub sequences
public class SubsequenceWithGivenSum {
    private static final List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 1));

    public static void main(String[] args) {
        List<Integer> ds = new ArrayList<>();

//        printSubSequence(0, nums, ds, 0, 2);
        System.out.println(countSubSequence(0, nums, 0, 3));
    }

    private static boolean printSubSequence(int index, List<Integer> nums, List<Integer> ds, int curSum, int target) {
        if(index == nums.size()) {
            if(curSum == target) {
                System.out.println(ds);
                return true;
            }
            return false;
        }

        //pick current element
        ds.add(nums.get(index));
        curSum = curSum + nums.get(index);

        if(printSubSequence(index + 1, nums, ds, curSum, target)) return true;

        //not pick the element
        ds.remove(ds.size() - 1);
        curSum -= nums.get(index);

        if(printSubSequence(index + 1, nums, ds, curSum, target)) return true;

        return false;
    }

    private static int countSubSequence(int index, List<Integer> nums, int curSum, int target) {
        if(index == nums.size()) {
            if(curSum == target) {
                return 1;
            }
            return 0;
        }

        //pick current element
        curSum = curSum + nums.get(index);

        int result = countSubSequence(index + 1, nums, curSum, target);

        //not pick the element
        curSum -= nums.get(index);

        result += countSubSequence(index + 1, nums, curSum, target);

        return result;
    }
}
