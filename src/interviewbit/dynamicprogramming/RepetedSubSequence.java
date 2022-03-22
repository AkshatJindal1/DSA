package interviewbit.dynamicprogramming;

import java.util.*;

public class RepetedSubSequence {

    public static int anytwo(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; ++i) dp[i][i] = 1;

        for(int i = 0; i < n; ++i) {
            if(A.charAt(i) == A.charAt(0)) dp[i][0] = 1;
        }
        for(int i = 2; i < n; ++i) {
            for(int j = 1; j < i; ++j) {
                if(A.charAt(i) == A.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                printGrid(dp);
                System.out.println();
                if(dp[i][j] >= 2) return 1;
            }
        }

        printGrid(dp);
        return 0;
    }

    private static void printGrid(int[][] grid) {
        for(int[] x: grid) {
            for(int i : x) System.out.print(i + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(anytwo("abba"));
    }
}
