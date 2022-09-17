package com.manoj.tabulation.substring;

import java.util.Arrays;

/* Reversing the given string and finding out longest common substring won't work in all the cases.*/
public class LongestPalindromicSubstring {
    private static final String s = "cbbd";
    private static int[][] dp = null;

    public static void main(String[] args) {
        System.out.println(lps(s));

        print2D(dp);
    }

    private static int lps(String s) {
        StringBuilder b = new StringBuilder(s);
        b.reverse();

        System.out.println(s);
        System.out.println(b.toString());

        return lcs(s, b.toString());
    }

    private static int lcs(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        int lcsSubstringLength = 0;

        dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    lcsSubstringLength = Math.max(lcsSubstringLength, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }

        return lcsSubstringLength;
    }

    public static void print2D(int mat[][])
    {
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}
