public class SofiGetMaxJobs {

    public static int getMaximumJobs(int n, int m, int k) {
        // Adjust k to be 0-indexed for easier calculations
        k--;

        if (m < n) {
            return 0;
        }

        int left = 1;
        int right = m - (n - 1);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(n, m, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static boolean isPossible(int n, int m, int k, int maxJobs) {
        long totalJobs = 0;

        for (int i = 0; i < n; i++) {
            int jobsForProcessor = Math.max(1, maxJobs - Math.abs(k - i));
            totalJobs += jobsForProcessor;
        }

        return totalJobs <= m;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumJobs(5, 11, 5));
    }

}
