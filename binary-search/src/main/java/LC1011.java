import java.util.stream.IntStream;

class LC1011 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;

        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int totalWeight = IntStream.of(weights).sum();
        int low = 1;
        int high = totalWeight;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            int dayUsingMid = getDays(weights, mid);

            if (dayUsingMid <= days) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return ans;
    }

    private static int getDays(int[] weights, int mid) {
        int days = 0;
        int weight = 0;

        for (int n : weights) {

            if (weight + n <= mid) {
                weight += n;
            } else {
                days++;
                weight = n;
            }
        }

        return days + 1;
    }
}