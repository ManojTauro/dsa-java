public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 10, 11, 12, 19};
        int x = 5;

        System.out.println(lowerBound(arr, x));
    }

    private static int lowerBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        int ans = arr.length;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] <= x) {
                low = mid + 1;
                ans = arr[mid];
            } else high = mid - 1;
        }

        return ans;
    }
}
