package com.manoj;

import java.util.List;

public class TriangleLC {
    public static void main(String[] args) {
        int[][] array = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3));

        System.out.println(minimumTotalTabulation(triangle));
    }

    private static int minimumTotalTabulation(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();

        int[][] table = new int[rows][cols];

        for (int i = 0; i < cols; i++)
            table[rows - 1][i] = triangle.get(rows - 1).get(i);

        for (int row = rows - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int leftD = triangle.get(row).get(col) + table[row + 1][col];
                int rightD = triangle.get(row).get(col) + table[row + 1][col + 1];

                table[row][col] = Math.min(leftD, rightD);
            }
        }

        return table[0][0];
    }
}
