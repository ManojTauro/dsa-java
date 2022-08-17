package com.manoj.tabulation.gridtraveller;

public class GridTraveller {
    public static void main(String[] args) {
        System.out.println(gridTraveller(3,3));
    }

    private static int gridTraveller(int m, int n) {
        int[][] table = new int[m+1][n+1];

        table[1][1] = 1;

        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                int cur = table[i][j];

                if(j<n) table[i][j+1] += cur;
                if(i<m) table[i+1][j] += cur;
            }
        }

        return table[m][n];
    }
}
