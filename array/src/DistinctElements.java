//printing distinct elements when there more than 2 occurrences of the same element
//https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
public class DistinctElements {
    private static int nums[] = { 0, 4, 3, 2, 4, 8, 2, 3, 0 };

    public static void main(String[] args) {
        int len = nums.length;

        for(int i=0; i<len; i++) {
            int index = nums[i] % len;
            nums[index] = nums[index] + len;
        }

        for(int i=0; i<len; i++) {
            if(nums[i] >= len * 2) System.out.print(i+" ");
        }
    }
}
