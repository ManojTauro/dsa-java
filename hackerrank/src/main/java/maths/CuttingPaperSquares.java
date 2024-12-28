package maths;

public class CuttingPaperSquares {
    public static void main(String[] args) {
        System.out.println(solve(689715240, 759842301));
    }

    public static long solve(int n, int m) {
        return (long) ((n - 1) + (long) n * (m - 1));
    }
}
