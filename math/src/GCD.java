public class GCD {
    public static void main(String[] args) {
        System.out.println("GCD of (24, 36): " + findGCD(24, 36));
        System.out.println("GCD of (1701, 3768): " + findGCD(1701, 3768));
        System.out.println("GCD of (1, 5): " + findGCD(1, 5));
        System.out.println("GCD of (10, 100): " + findGCD(10, 100));
        System.out.println("GCD of (22, 131): " + findGCD(22, 131));
    }

    private static int findGCD(int n1, int n2) {
        int min = Math.min(n1, n2);

        if (n1 % min == 0 && n2 % min == 0) return min;

        for (int i = min / 2; i >= 2; i--) {
            if (n1 % i == 0 && n2 % i == 0) return i;
        }

        return 1;
    }
}