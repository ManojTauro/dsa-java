import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        int r1 = m - 1;
        int r2 = n - 1;
        int w = m + n - 1;

        while (r1 >= 0 && r2 >= 0) {
            if (nums1[r1] <= nums2[r2]) {
                nums1[w--] = nums2[r2--];

            } else {
                nums1[w--] = nums1[r1--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
