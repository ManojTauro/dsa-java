import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 3};
        int n = 5;

        long arraySum = IntStream.of(a).sum();
        long sumOfNNumbers = (n * (n + 1)) / 2;
        long diff = arraySum - sumOfNNumbers; // X - Y

        long arraySquareSum = IntStream.of(a).map(num -> num * num).sum();
        long sumOfNSquareNumbers = (n * (n + 1) * (2 * n + 1)) / 6;
        long squareSumDiff = arraySquareSum - sumOfNSquareNumbers; // X^2 - Y^2

        // X + Y = (X^2 - Y^2) / (X - Y)
        long missingPlusRepeating = squareSumDiff / diff;

        long X = (diff + missingPlusRepeating) / 2;
        long Y = X - diff;

        int[] ans = {(int) X, (int) Y};

        System.out.println(Arrays.toString(ans));
    }
}
