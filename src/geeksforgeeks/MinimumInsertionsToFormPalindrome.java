package geeksforgeeks;

import java.util.Arrays;

public class MinimumInsertionsToFormPalindrome {

    public int findMinInsertions(char[] chars) {
        int n = chars.length;
        int[][] dp = new int[n][n];

        for(int gaps = 1; gaps < n; ++gaps) {
            int left = 0;
            for(int right = gaps; right < n; ++right) {
                dp[left][right] = chars[left] == chars[right]
                        ? dp[left + 1][right - 1]   // if chars match put count as what is required for elements between left and right
                        : Math.min(dp[left][right - 1], dp[left + 1][right]) + 1;
                left++;
            }
        }

//        printMatrix(dp);
        return dp[0][n - 1];

    }

    private void printMatrix(int[][] mat) {
        for(int[] ar: mat) {
            for(int n: ar) System.out.print(n + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str= "geeks";
        System.out.println(new MinimumInsertionsToFormPalindrome().findMinInsertions(str.toCharArray()));
    }
}
