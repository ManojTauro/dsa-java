//https://www.youtube.com/watch?v=SxtxCSfSGlo
public class SubarrayWithOddProduct {
    private static final int[] input = {12, 15, 7, 3, 25, 6, 2, 1, 1, 7};

    public static void main(String[] args) {
        int result = 0;
        int prod = 1;

        int left=0, right = 0;

        while (right < input.length) {
            prod *= input[right];

            while (prod % 2 == 0)
                prod /= input[left++];

            result += right - left + 1;

            right++;
        }

        System.out.println("Sub Array count = "+result);
    }
}
