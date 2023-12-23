package com.manoj;

public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}};
        System.out.println(minimumPathSumTab(triangle));
    }

    private static int minimumPathSumTab(int[][] triangle) {
        int m = triangle.length;
        int n = triangle[m - 1].length;

        int[][] table = new int[m][n];

        System.arraycopy(triangle[m - 1], 0, table[m - 1], 0, n);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int up = triangle[i][j] + table[i + 1][j]; // up
                int right = triangle[i][j] + table[i + 1][j + 1];

                table[i][j] = Math.min(up, right);

            }
        }

        return table[0][0];
    }
}
