import java.util.Arrays;

public class CeilTheFloor {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};
        int x = 7;

        Arrays.sort(arr);

        int ceil = getCeil(arr, x);
        int floor = getFloor(arr, x);

        int[] ans = {floor, ceil};

        System.out.println(Arrays.toString(ans));
    }

    private static int getFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        long ans = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] >= x) {
                high = mid - 1;
                ans = mid;
            } else low = mid + 1;
        }

        return (int) ans;
    }

    private
    static int getCeil(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        long ans = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] >= x) {

                high = mid - 1;
                ans = mid;
            } else low = mid + 1;
        }

        return (int) ans;
    }
}
