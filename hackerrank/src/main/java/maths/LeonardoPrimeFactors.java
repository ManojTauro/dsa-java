package maths;

public class LeonardoPrimeFactors {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(primeCount(n));
    }

    public static int primeCount(long n) {
        long prime = 1;
        int count = 0;

        int i = 2;
        while (prime < n) {
            if (isPrime(i)) {
                prime *= i;
                count++;
            }
            i++;
        }

        return count - 1;
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;

        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0) return false;

        return true;
    }
}
