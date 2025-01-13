/*
    https://projecteuler.net/problem=1
*/

public class Problem_1 {
    public static void main(String[] args) {
        optimized();
    }

    private static void optimized() {
        int N = 1000;
        int num1 = 3;
        int num2 = 5;

        long ans = sumOfMultiples(N, 3) + sumOfMultiples(N, 5) - sumOfMultiples(N, num1 * num2);

        System.out.println(ans);
    }

    private static long sumOfMultiples(int N, int num) {
        int k = (N - 1) / num; // Total multiples of 'num' below N

        return (long) num * k * (k + 1) / 2;
    }

    private static void bruteForce() {
        long sum = 0;

        for (int num = 1; num < 1000; num++) {
            if (num % 3 == 0) sum += num;
            else if (num % 5 == 0) sum += num;
        }

        System.out.println(sum);
    }
}
