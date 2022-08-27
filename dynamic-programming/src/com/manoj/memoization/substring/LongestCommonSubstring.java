package com.manoj.memoization.substring;

import java.util.Arrays;

//https://stackoverflow.com/questions/30859547/dp-memoized-approach-for-longest-common-substring
public class LongestCommonSubstring {
    private static final String s1 = "abcd";
    private static final String s2 = "abcd";
    private static int[][] dp = null;

    public static void main(String[] args) {
        dp = new int[s1.length() + 1][s2.length() + 1];

        for(int[] a: dp)
            Arrays.fill(a, -1);

        System.out.println(lcSubstring(s1, s2, s1.length(), s2.length(), 0, dp));
    }

    private static int lcSubstring(String str1, String str2, int m, int n, int curLen, int[][] dp) {
        if(m == 0 || n == 0) return curLen;

        if(dp[m][n] != -1) return dp[m][n];

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int c2 = 0;

        if(s1[m-1] == s2[n-1])  curLen = lcSubstring(str1, str2, m - 1, n - 1, curLen + 1, dp);
        else c2 = Math.max(lcSubstring(str1, str2, m - 1, n, 0, dp), lcSubstring(str1, str2, m, n - 1, 0, dp));

        dp[m][n] = Math.max(curLen, c2);

        return dp[m][n];
    }
}
