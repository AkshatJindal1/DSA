package leetcode;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) { // top down
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for(int i = 1; i < m + 1; ++i) dp[i][0] = dp[i - 1][0] + 1;
        for(int i = 1; i < n + 1; ++i) dp[0][i] = dp[0][ i - 1] + 1;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(word1.charAt(i) == word2.charAt(j)) dp[i + 1][j + 1] = dp[i][j];
                else {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i][ j + 1], Math.min(dp[i + 1][j], dp[i][j]));
                }
            }
        }
        return dp[m][n];
    }

    int[][] DP;
    char[] w1;
    char[] w2;
    public int minDistanceBottomUp(String word1, String word2) { // bottomUp
        int m = word1.length();
        int n = word2.length();
        DP = new int[m + 1][n + 1];
        for(int[] row: DP) Arrays.fill(row, - 1);
        w1 = word1.toCharArray();
        w2 = word2.toCharArray();
        return solve(m - 1, n - 1);
    }

    int solve(int m, int n) {
        if(m == -1) return n + 1;
        if(n == -1) return m + 1;
        if(DP[m][n] != -1) return DP[m][n];
        if(w1[m] == w2[n]) return DP[m][n] = solve(m - 1, n - 1);
        return DP[m][n] = 1 + Math.min(solve(m -1, n - 1), Math.min(solve(m - 1, n), solve(m, n - 1)));
    }


    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("horse", "ros"));
    }
}
