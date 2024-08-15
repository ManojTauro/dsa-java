public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int t = 3;

        System.out.println(f(nums, t));
    }

    private static boolean f(int[] nums, int t) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == t) return true;
            else if (nums[low] <= nums[mid]) {
                if (nums[mid] >= t && nums[low] <= t) {
                    while (nums[mid] == nums[high]) high--;
                    high--;
                } else {
                    while (nums[mid] == nums[low]) low++;
                    low++;
                }
            } else {
                if (nums[mid] >= t && nums[low] <= t) {
                    while (nums[mid] == nums[low]) low++;
                    low++;
                } else {
                    while (nums[mid] == nums[high]) high--;
                    high--;
                }
            }
        }

        return false;
    }
}
