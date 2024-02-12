import java.util.Arrays;

// For a problem statement please refer
// C:\Users\Manu\Desktop\Manoj\Studies\Interview\full time\microsoft
public class Task2 {
    public static void main(String[] args) {
        int[] X = {2, 4, 2, 6, 7, 1};
        int[] Y = {0, 5, 3, 2, 1, 5};

        int[] X1 = {4, 8, 2, 2, 1, 4};
        int[] Y1 = {1, 2, 3, 1, 2, 3};

        int[] X2 = {0, 3, 6, 5};
        int[] Y2 = {0, 3, 2, 4};

        System.out.println(solution(X, Y, 2));
        System.out.println(solution(X1, Y1, 3));
        System.out.println(solution(X2, Y2, 1));
    }

    public static int solution(int[] X, int[] Y, int W) {
        int len = X.length;

        Arrays.sort(X);

        int current_covered_roller = -W;
        int rounds = 0;

        for (int pathHole : X) {
            if (pathHole > current_covered_roller) {
                rounds++;
                current_covered_roller = pathHole + W;
            }
        }

        return rounds;
    }
}
