public class GCD {
    public static void main(String[] args) {
        System.out.println(findGCD(24, 36));
    }

    private static int findGCD(int n1, int n2) {
        int gcd = 1;
        int smallNumber = Math.min(n1, n2);

        for (int i = 1; i <= smallNumber; i++) {
            if (n1 % i == 0 && n2 % i == 0) gcd = i;
        }

        return gcd;
    }
}