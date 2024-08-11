package IBM;

public class DominatingXORPairs {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2};

        System.out.println(countPairs(arr));
    }

    private static int countPairs(int[] arr) {
        int N = arr.length;
        int ans = 0;

        int[] bits = new int[32];

        for (int j : arr) {
            int val = (int) (Math.log(j) / Math.log(2));
            ans += bits[val];
            bits[val]++;
        }

        return N * (N - 1) / 2 - ans;
    }
}
