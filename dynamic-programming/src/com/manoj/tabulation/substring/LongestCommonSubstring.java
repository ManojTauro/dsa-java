package com.manoj.tabulation.substring;

//https://www.youtube.com/watch?v=_wP9mWNPL5w&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY
public class LongestCommonSubstring {
    private static final String s1 = "abcd";
    private static final String s2 = "abcd";
    private static int[][] dp = null;

    public static void main(String[] args) {
        System.out.println(lcSubstring(s1, s2));
    }

    private static int lcSubstring(String str1, String str2) {
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
}
