public class Question_17 {
    public static void main(String[] args) {
        int N = 3;
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotateMatrix(matrix, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] m, int N) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = m[i][j];
                m[i][j] = m[N - j - 1][i];
                m[N - j - 1][i] = m[N - 1 - i][N - 1 - j];
                m[N - 1 - i][N - 1 - j] = m[j][N - 1 - j];
                m[j][N - 1 - i] = temp;
            }
        }
    }
}
