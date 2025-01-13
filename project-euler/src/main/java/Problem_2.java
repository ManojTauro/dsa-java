/*
https://projecteuler.net/problem=2

Ref: https://raw.org/puzzle/project-euler/problem-2/
 */
public class Problem_2 {
    public static void main(String[] args) {
        optimized();
    }

    private static void optimized() {
        long secondLastEven = 2;
        long lastEven = 8;
        long sum = 0;
        long nextEven = secondLastEven + lastEven;

        while (nextEven <= 4_000_000) {
            sum += nextEven;
            nextEven = secondLastEven + (4 * lastEven);
            secondLastEven = lastEven;
            lastEven = nextEven;
        }

        System.out.println(sum);
    }

    private static void bruteForce() {
        int prev1 = 0;
        int prev2 = 1;
        long sum = 0;

        int cur = 0;
        while (cur < 4_000_000) {
            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;

            if (cur % 2 == 0) sum += cur;
        }

        System.out.println(sum);
    }
}
