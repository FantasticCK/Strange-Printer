package com.company;

public class Main {

    public static void main(String[] args) {
        new Solution().strangePrinter("tbgtgb");
    }
}

class Solution {
    public int strangePrinter(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        int res = dfs(s, 0, n - 1, dp);
        return res;
    }

    private int dfs(String s, int st, int ed, int[][] dp) {
        if (st > ed)
            return 0;
        if (st == ed) {
            dp[st][ed] = 1;
            return 1;
        }
        if (dp[st][ed] != 0)
            return dp[st][ed];

        dp[st][ed] = dfs(s, st, ed - 1, dp) + 1;
        char edChar = s.charAt(ed);
        for (int i = ed; i>= st; i--) {
            char c =  s.charAt(i);
            if (c != edChar){
                continue;
            }

            dp[st][ed] = Math.min(dp[st][ed], dfs(s, st, i, dp) + dfs(s, i + 1, ed - 1, dp));
        }

        return dp[st][ed];
    }
}