package com.manoj.tabulation.subsequences;

//https://www.youtube.com/watch?v=-zI4mrF2Pb4&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=27
public class LongestCommonSubsequence {
    private static final String s1 = "abc";
    private static final String s2 = "abc";
    private static int[][] dp = null;
    
    public static void main(String[] args) {
        System.out.println(lcs(s1.toCharArray(), s2.toCharArray()));

        System.out.println(getLCS());
    }

    private static int lcs(char[] s1, char[] s2) {
        int m = s1.length;
        int n = s2.length;
        dp = new int[m+1][n+1];

        //base case
        for(int i=0; i<=m; i++) dp[i][0] = 0;
        for(int j=0; j<=n; j++) dp[0][j] = 0;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1[i-1] == s2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
    
    private static String getLCS() {
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();

        int len = dp[s1.length()][s2.length()];
        StringBuilder builder = new StringBuilder();
        builder.setLength(len);

        int index = len-1;
        int i = t1.length;
        int j = t2.length;

        while (i>0 && j>0) {
            if(t1[i-1] == t2[j-1]) {
                builder.setCharAt(index--, t1[i-1]);
                i--;
                j--;
            }
            else if(t1[i-1] > t2[j-1]) i--;
            else j--;
        }

        return builder.toString();
    }
}
